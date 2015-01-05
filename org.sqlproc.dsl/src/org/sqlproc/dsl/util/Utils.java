package org.sqlproc.dsl.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.sqlproc.dsl.ImportManager;
import org.sqlproc.dsl.processorDsl.AbstractEntity;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.Column;
import org.sqlproc.dsl.processorDsl.DaoDirective;
import org.sqlproc.dsl.processorDsl.DaoDirectiveAbstract;
import org.sqlproc.dsl.processorDsl.DaoDirectiveExtends;
import org.sqlproc.dsl.processorDsl.DaoDirectiveFinal;
import org.sqlproc.dsl.processorDsl.DaoDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.DaoType;
import org.sqlproc.dsl.processorDsl.EnumDirective;
import org.sqlproc.dsl.processorDsl.EnumDirectiveExtends;
import org.sqlproc.dsl.processorDsl.EnumDirectiveFinal;
import org.sqlproc.dsl.processorDsl.EnumDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.EnumEntity;
import org.sqlproc.dsl.processorDsl.EnumProperty;
import org.sqlproc.dsl.processorDsl.ExtendedColumn;
import org.sqlproc.dsl.processorDsl.ExtendedMappingItem;
import org.sqlproc.dsl.processorDsl.FunctionDefinition;
import org.sqlproc.dsl.processorDsl.MappingColumn;
import org.sqlproc.dsl.processorDsl.MappingRule;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.PackageDeclaration;
import org.sqlproc.dsl.processorDsl.PackageDirective;
import org.sqlproc.dsl.processorDsl.PackageDirectiveSuffix;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.PojoDefinition;
import org.sqlproc.dsl.processorDsl.PojoDirective;
import org.sqlproc.dsl.processorDsl.PojoDirectiveAbstract;
import org.sqlproc.dsl.processorDsl.PojoDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.PojoDirectiveExtends;
import org.sqlproc.dsl.processorDsl.PojoDirectiveFinal;
import org.sqlproc.dsl.processorDsl.PojoDirectiveOperators;
import org.sqlproc.dsl.processorDsl.PojoDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirective;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveCreateCol;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveIndex;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectivePrimaryKey;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveRequired;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveUpdateCol;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveVersion;
import org.sqlproc.dsl.processorDsl.PojoType;
import org.sqlproc.dsl.processorDsl.ProcedureDefinition;
import org.sqlproc.dsl.processorDsl.TableDefinition;
import org.sqlproc.dsl.resolver.DbResolver;
import org.sqlproc.dsl.resolver.DbResolver.DbType;

public class Utils {

    // public static EnumEntity enumEntity(AnnotatedEntity e) {
    // if (e.getEntity() instanceof EnumEntity)
    // return (EnumEntity) e.getEntity();
    // return null;
    // }
    //
    // public static PojoEntity pojoEntity(AnnotatedEntity e) {
    // if (e.getEntity() instanceof PojoEntity)
    // return (PojoEntity) e.getEntity();
    // return null;
    // }
    //
    // public static String getAnnotationValue(AnnotationProperty a) {
    // String value = a.getNumber();
    // if (value != null)
    // return value;
    // value = a.getValue();
    // if (value != null)
    // return value;
    // value = a.getConstant();
    // if (value != null)
    // value = value.replaceAll("___", ".");
    // if (a.getType() != null || a.getRef() != null)
    // return "." + value;
    // return value;
    // }

    public static String resourceDir(Resource resource) {
        String uri = (resource.getURI() != null) ? resource.getURI().toString() : null;
        String dir = null;
        if (uri != null) {
            dir = uri;
            int ix = uri.lastIndexOf("/");
            if (ix > 0)
                dir = uri.substring(0, ix);
        }
        return dir;
    }

    public static boolean isList(PojoProperty f) {
        if (f.getType() == null || f.getType().getType() == null)
            return false;
        if (f.getType().getType().getSimpleName().equals("List"))
            return true;
        return false;
    }

    public static boolean isRequired(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return false;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveRequired)
                return true;
        }
        return false;
    }

    // public static boolean isAttribute(PojoProperty f) {
    // if (f.getAttrs() == null || f.getAttrs().isEmpty())
    // return true;
    // return false;
    // }

    public static String getIndex(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return null;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveIndex)
                return ((PojoPropertyDirectiveIndex) directive).getIndex();
        }
        return null;
    }

    public static String getUpdateColumn1(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return null;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveUpdateCol)
                return ((PojoPropertyDirectiveUpdateCol) directive).getUpdateColumn1();
        }
        return null;
    }

    public static String getUpdateColumn2(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return null;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveUpdateCol)
                return ((PojoPropertyDirectiveUpdateCol) directive).getUpdateColumn2();
        }
        return null;
    }

    public static String getCreateColumn1(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return null;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveCreateCol)
                return ((PojoPropertyDirectiveCreateCol) directive).getCreateColumn1();
        }
        return null;
    }

    public static String getCreateColumn2(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return null;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveCreateCol)
                return ((PojoPropertyDirectiveCreateCol) directive).getCreateColumn2();
        }
        return null;
    }

    public static boolean isDiscriminator(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return false;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveDiscriminator)
                return true;
        }
        return false;
    }

    public static boolean isPrimaryKey(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return false;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectivePrimaryKey)
                return true;
        }
        return false;
    }

    public static boolean isAbstract(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return false;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveAbstract)
                return true;
        }
        return false;
    }

    public static boolean hasOperators(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return false;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveOperators)
                return true;
        }
        return false;
    }

    public static String getOperatorsSuffix(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveOperators)
                return ((PojoDirectiveOperators) directive).getOperatorsSuffix();
        }
        return null;
    }

    public static boolean isOptLock(PojoProperty f) {
        if (f.getDirectives() == null || f.getDirectives().isEmpty())
            return false;
        for (PojoPropertyDirective directive : f.getDirectives()) {
            if (directive instanceof PojoPropertyDirectiveVersion)
                return true;
        }
        return false;
    }

    public static boolean isAbstract(PojoDao d) {
        if (d.getDirectives() == null || d.getDirectives().isEmpty())
            return false;
        for (DaoDirective directive : d.getDirectives()) {
            if (directive instanceof DaoDirectiveAbstract)
                return true;
        }
        return false;
    }

    public static boolean isFinal(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return false;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveFinal)
                return true;
        }
        return false;
    }

    public static boolean isFinal(EnumEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return false;
        for (EnumDirective directive : e.getDirectives()) {
            if (directive instanceof EnumDirectiveFinal)
                return true;
        }
        return false;
    }

    public static boolean isFinal(PojoDao d) {
        if (d.getDirectives() == null || d.getDirectives().isEmpty())
            return false;
        for (DaoDirective directive : d.getDirectives()) {
            if (directive instanceof DaoDirectiveFinal)
                return true;
        }
        return false;
    }

    public static PojoType getSuperType(EnumEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (EnumDirective directive : e.getDirectives()) {
            if (directive instanceof EnumDirectiveExtends)
                return ((EnumDirectiveExtends) directive).getSuperType();
        }
        return null;
    }

    public static PojoType getSuperType(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveExtends)
                return ((PojoDirectiveExtends) directive).getSuperType();
        }
        return null;
    }

    // public static String getDaoImplements(PojoDao dao, Implements impl) {
    // StringBuilder sb = new StringBuilder();
    // sb.append(impl.getImplements().getSimpleName());
    // if (dao.isPojoGenerics() && impl.isGenerics())
    // sb.append("<").append(dao.getPojo().getName()).append(">");
    // return sb.toString();
    // }

    public static DaoType getSuperType(PojoDao d) {
        if (d.getDirectives() == null || d.getDirectives().isEmpty())
            return null;
        for (DaoDirective directive : d.getDirectives()) {
            if (directive instanceof DaoDirectiveExtends)
                return ((DaoDirectiveExtends) directive).getSuperType();
        }
        return null;
    }

    public static String getDiscriminator(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveDiscriminator)
                return ((PojoDirectiveDiscriminator) directive).getDiscriminator();
        }
        return null;
    }

    public static String getSernum(EnumEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (EnumDirective directive : e.getDirectives()) {
            if (directive instanceof EnumDirectiveSerializable)
                return ((EnumDirectiveSerializable) directive).getSernum();
        }
        return null;
    }

    public static String getSernum(PojoEntity e) {
        if (e.getDirectives() == null || e.getDirectives().isEmpty())
            return null;
        for (PojoDirective directive : e.getDirectives()) {
            if (directive instanceof PojoDirectiveSerializable)
                return ((PojoDirectiveSerializable) directive).getSernum();
        }
        return null;
    }

    public static String getSernum(PojoDao d) {
        if (d.getDirectives() == null || d.getDirectives().isEmpty())
            return null;
        for (DaoDirective directive : d.getDirectives()) {
            if (directive instanceof DaoDirectiveSerializable)
                return ((DaoDirectiveSerializable) directive).getSernum();
        }
        return null;
    }

    public static List<PojoProperty> requiredFeatures(PojoEntity e) {
        List<PojoProperty> features = new ArrayList<PojoProperty>();
        if (e == null || e.getFeatures() == null)
            return features;
        for (PojoProperty f : e.getFeatures()) {
            if (isRequired(f))
                features.add(f);
        }
        PojoType s = getSuperType(e);
        if (s == null || !(s instanceof PojoEntity))
            return features;
        features.addAll(requiredFeatures((PojoEntity) s));
        return features;
    }

    public static List<PojoProperty> attributes(PojoEntity e) {
        List<PojoProperty> features = new ArrayList<PojoProperty>();
        if (e == null || e.getFeatures() == null)
            return features;
        for (PojoProperty f : e.getFeatures()) {
            features.add(f);
        }
        PojoType s = getSuperType(e);
        if (s == null || !(s instanceof PojoEntity))
            return features;
        features.addAll(attributes((PojoEntity) s));
        return features;
    }

    public static PojoProperty getAttribute(PojoEntity e, String name) {
        if (e == null || e.getFeatures() == null)
            return null;
        for (PojoProperty f : e.getFeatures()) {
            if (f.getName().equals(name))
                return f;
        }
        PojoType s = getSuperType(e);
        if (s == null || !(s instanceof PojoEntity))
            return null;
        return getAttribute((PojoEntity) s, name);
    }

    public static boolean hasName(PojoProperty f, String name) {
        if (f.getName().equals(name))
            return true;
        return false;
    }

    public static String getTokenFromModifier(MetaStatement statement, String tokenName) {
        if (statement.getModifiers() == null || statement.getModifiers().isEmpty()) {
            return null;
        }
        for (String filter : statement.getModifiers()) {
            int ix = filter.indexOf('=');
            if (ix <= 0)
                continue;
            String key = filter.substring(0, ix);
            String val = filter.substring(ix + 1);
            if (key.equals(tokenName)) {
                return val;
            }
        }
        return null;
    }

    public static String getTokenFromModifier(MappingRule rule, String tokenName) {
        if (rule.getModifiers() == null || rule.getModifiers().isEmpty()) {
            return null;
        }
        for (String filter : rule.getModifiers()) {
            int ix = filter.indexOf('=');
            if (ix <= 0)
                continue;
            String key = filter.substring(0, ix);
            String val = filter.substring(ix + 1);
            if (key.equals(tokenName)) {
                return val;
            }
        }
        return null;
    }

    public static String getTokenFromModifier(MetaStatement statement, String tokenName, String tokenSuffix) {
        if (statement.getModifiers() == null || statement.getModifiers().isEmpty()) {
            return null;
        }
        for (String filter : statement.getModifiers()) {
            int ix = filter.indexOf('=');
            if (ix <= 0)
                continue;
            String key = filter.substring(0, ix);
            String val = filter.substring(ix + 1);
            if (tokenSuffix != null) {
                int ix2 = val.indexOf('=');
                if (ix2 <= 0)
                    continue;
                if (!tokenSuffix.equals(val.substring(ix2 + 1)))
                    continue;
                val = val.substring(0, ix2);
            }
            if (key.equals(tokenName)) {
                return val;
            }
        }
        return null;
    }

    public static List<String> getTokensFromModifier(MetaStatement statement, String tokenName) {
        List<String> result = new ArrayList<String>();
        if (statement.getModifiers() == null || statement.getModifiers().isEmpty()) {
            return result;
        }
        for (String filter : statement.getModifiers()) {
            int ix = filter.indexOf('=');
            if (ix <= 0)
                continue;
            String key = filter.substring(0, ix);
            String val = filter.substring(ix + 1);
            int ix2 = val.indexOf('=');
            // String val2 = (ix2 > 0) ? val.substring(ix2 + 1) : null;
            val = (ix2 > 0) ? val.substring(0, ix2) : val;
            if (key.equals(tokenName)) {
                result.add(val);
            }
        }
        return result;
    }

    public static PojoEntity findEntity(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope, String name) {
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            PackageDeclaration packageDeclaration = (PackageDeclaration) artifacts.eResource().getResourceSet()
                    .getEObject(description.getEObjectURI(), true);
            for (AbstractEntity aEntity : packageDeclaration.getElements()) {
                if (aEntity instanceof PojoEntity) {
                    PojoEntity entity = (PojoEntity) aEntity;
                    if (name.equals(entity.getName())) {
                        return entity;
                    }
                }
            }
        }
        return null;
    }

    public static PojoDefinition findPojo(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope, String name) {
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            if ((qualifiedNameConverter != null && qualifiedNameConverter.toQualifiedName(name).equals(
                    description.getName()))
                    || name.equals(description.getName().toString())) {
                return (PojoDefinition) artifacts.eResource().getResourceSet()
                        .getEObject(description.getEObjectURI(), true);
            }
        }
        return null;
    }

    public static TableDefinition findTable(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope, String name) {
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            if ((qualifiedNameConverter != null && qualifiedNameConverter.toQualifiedName(name).equals(
                    description.getName()))
                    || name.equals(description.getName().toString())) {
                return (TableDefinition) artifacts.eResource().getResourceSet()
                        .getEObject(description.getEObjectURI(), true);
            }
        }
        return null;
    }

    public static List<String> findTables(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof TableDefinition)
                names.add(((TableDefinition) obj).getTable());
        }
        return names;
    }

    public static List<String> findFunctions(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof FunctionDefinition)
                names.add(((FunctionDefinition) obj).getTable());
        }
        return names;
    }

    public static List<String> findProcedures(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof ProcedureDefinition)
                names.add(((ProcedureDefinition) obj).getTable());
        }
        return names;
    }

    public static String constName(PojoProperty f) {
        return constName(f.getName());
    }

    // public static String constName2(PojoProperty f) {
    // StringBuilder result = new StringBuilder("");
    // boolean first = true;
    // for (PojoProperty p : f.getAttrs()) {
    // if (first)
    // first = false;
    // else
    // result.append("_");
    // result.append(constName(p.getName()));
    // }
    // return result.toString();
    // }

    public static String constName(String name) {
        String result = "";
        int last = 0;
        for (int i = 0, l = name.length(); i < l; i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                result = result + name.substring(last, i).toUpperCase() + "_";
                last = i;
            }
        }
        if (last < name.length())
            result = result + name.substring(last).toUpperCase();
        return result;
    }

    public static String dbName(PojoEntity e) {
        String result = "";
        int last = 0;
        boolean lastDigit = false;
        for (int i = 0, l = e.getName().length(); i < l; i++) {
            char c = e.getName().charAt(i);
            if (Character.isUpperCase(c) || (Character.isDigit(c) && !lastDigit)) {
                result = result + e.getName().substring(last, i).toUpperCase() + "_";
                last = i;
            }
            lastDigit = Character.isDigit(c);
        }
        if (last < e.getName().length())
            result = result + e.getName().substring(last).toUpperCase();
        return result.startsWith("_") ? result.substring(1) : result;
    }

    // public static String dbName(PojoMethod e) {
    // String result = "";
    // int last = 0;
    // boolean lastDigit = false;
    // for (int i = 0, l = e.getName().length(); i < l; i++) {
    // char c = e.getName().charAt(i);
    // if (Character.isUpperCase(c) || (Character.isDigit(c) && !lastDigit)) {
    // result = result + e.getName().substring(last, i).toUpperCase() + "_";
    // last = i;
    // }
    // lastDigit = Character.isDigit(c);
    // }
    // if (last < e.getName().length())
    // result = result + e.getName().substring(last).toUpperCase();
    // return result.startsWith("_") ? result.substring(1) : result;
    // }

    public static String getPackage(PojoEntity e) {
        PackageDeclaration packageDeclaration = EcoreUtil2.getContainerOfType(e, PackageDeclaration.class);
        return packageDeclaration.getName();
    }

    public static String getFullName(PojoEntity e1, PojoEntity e2, QualifiedName qn2, ImportManager im) {
        String sqn = qn2.toString();
        if (sqn.indexOf(".") > 0)
            return sqn;
        String pkg1 = getPackage(e1);
        String pkg2 = getPackage(e2);
        if (!pkg1.equals(pkg2))
            im.addImportFor(e2);
        return sqn;
    }

    public static String getPackage(EnumEntity e) {
        PackageDeclaration packageDeclaration = EcoreUtil2.getContainerOfType(e, PackageDeclaration.class);
        return packageDeclaration.getName();
    }

    public static String getFullName(EnumEntity e1, PojoEntity e2, QualifiedName qn2, ImportManager im) {
        String sqn = qn2.toString();
        if (sqn.indexOf(".") > 0)
            return sqn;
        String pkg1 = getPackage(e1);
        String pkg2 = getPackage(e2);
        if (!pkg1.equals(pkg2))
            im.addImportFor(e2);
        return sqn;
    }

    public static String getPackage(PojoDao e) {
        PackageDeclaration packageDeclaration = EcoreUtil2.getContainerOfType(e, PackageDeclaration.class);
        return packageDeclaration.getName();
    }

    public static String getFullName(PojoDao e1, PojoDao e2, QualifiedName qn2, ImportManager im) {
        String sqn = qn2.toString();
        if (sqn.indexOf(".") > 0)
            return sqn;
        String pkg1 = getPackage(e1);
        String pkg2 = getPackage(e2);
        if (!pkg1.equals(pkg2))
            im.addImportFor(e2);
        return sqn;
    }

    public static String getPackage(PojoProperty e) {
        PackageDeclaration packageDeclaration = EcoreUtil2.getContainerOfType(e, PackageDeclaration.class);
        return packageDeclaration.getName();
    }

    public static CharSequence getFullName(PojoEntity e1, PojoProperty e2, CharSequence qn2, ImportManager im) {
        String sqn = qn2.toString();
        if (sqn.indexOf(".") > 0)
            return qn2;
        String pkg1 = getPackage(e1);
        String pkg2 = getPackage(e2);
        if (!pkg1.equals(pkg2))
            im.addImportFor(e2, sqn);
        return qn2;
    }

    // public static Map<String, List<PojoMethodArg>> getToInits(PojoDao d) {
    // Map<String, List<PojoMethodArg>> result = new LinkedHashMap<String, List<PojoMethodArg>>();
    // for (ToInitMethod m : d.getToInits()) {
    // if (m.getArgs() != null && !m.getArgs().isEmpty()) {
    // result.put(m.getName(), new ArrayList<PojoMethodArg>());
    // for (PojoMethodArg a : m.getArgs()) {
    // result.get(m.getName()).add(a);
    // }
    // }
    // }
    // return result;
    // }

    public static PojoType getParent(PojoEntity e) {
        if (getDiscriminator(e) != null)
            return null;
        PojoType e2 = getSuperType(e);
        return e2;
    }

    public static boolean isFinal(MetaStatement m) {
        String finalToken = getTokenFromModifier(m, "final");
        if (finalToken != null)
            return true;
        return false;
    }

    public static PojoProperty getOptLock(PojoEntity e) {
        if (e == null || e.getFeatures() == null)
            return null;
        for (PojoProperty f : e.getFeatures()) {
            if (isOptLock(f))
                return f;
        }
        PojoType s = getSuperType(e);
        if (s == null || !(s instanceof PojoEntity))
            return null;
        return getOptLock((PojoEntity) s);
    }

    // public static String getName(Identifier identifier) {
    // StringBuilder sb = new StringBuilder();
    // boolean first = true;
    // for (ExtendedIdentifier ei : identifier.getIdentifiers()) {
    // if (first)
    // first = false;
    // else
    // sb.append(".");
    // sb.append(ei.getName());
    // }
    // return sb.toString();
    // }

    public static String getName(Column column) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (ExtendedColumn ei : column.getColumns()) {
            if (first)
                first = false;
            else
                sb.append(".");
            sb.append(ei.getCol().getName());
        }
        return sb.toString();
    }

    public static String getName(MappingColumn column) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (ExtendedMappingItem ei : column.getItems()) {
            if (first)
                first = false;
            else
                sb.append(".");
            sb.append(ei.getAttr().getName());
        }
        return sb.toString();
    }

    public static boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        for (int i = 0, l = s.length(); i < l; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    // public static boolean isCallUpdate(PojoMethod f) {
    // if (f.getModifiers1() == null || f.getModifiers1().isEmpty())
    // return false;
    // for (PojoMethodModifier modifier : f.getModifiers1()) {
    // if (modifier.isCallUpdate())
    // return true;
    // }
    // return false;
    // }
    //
    // public static boolean isCallFunction(PojoMethod f) {
    // if (f.getModifiers1() == null || f.getModifiers1().isEmpty())
    // return false;
    // for (PojoMethodModifier modifier : f.getModifiers1()) {
    // if (modifier.isCallFunction())
    // return true;
    // }
    // return false;
    // }
    //
    // public static boolean isCallQuery(PojoMethod f) {
    // if (f.getModifiers1() == null || f.getModifiers1().isEmpty())
    // return false;
    // for (PojoMethodModifier modifier : f.getModifiers1()) {
    // if (modifier.isCallQuery())
    // return true;
    // }
    // return false;
    // }
    //
    // public static boolean isCallQueryFunction(PojoMethod f) {
    // if (f.getModifiers1() == null || f.getModifiers1().isEmpty())
    // return false;
    // for (PojoMethodModifier modifier : f.getModifiers1()) {
    // if (modifier.isCallQueryFunction())
    // return true;
    // }
    // return false;
    // }
    //
    // public static boolean isCallSelectFunction(PojoMethod f) {
    // if (f.getModifiers1() == null || f.getModifiers1().isEmpty())
    // return false;
    // for (PojoMethodModifier modifier : f.getModifiers1()) {
    // if (modifier.isCallSelectFunction())
    // return true;
    // }
    // return false;
    // }

    public static EnumProperty getEnumAttr(EnumEntity e) {
        for (EnumProperty attr : e.getFeatures()) {
            if (attr.getType() != null)
                return attr;
        }
        return null;
    }

    // public static String getValue(EnumProperty p) {
    // if (p.getValue() == null)
    // return null;
    // return p.getValue().replaceAll("'", "\"");
    // }

    public static JvmType pojoMethod2jvmType(final PojoEntity e) {
        return new JvmType() {

            @Override
            public String getIdentifier() {
                return e.getName();
            }

            @Override
            public String getSimpleName() {
                return e.getName();
            }

            @Override
            public String getQualifiedName() {
                return getPackage(e) + "." + e.getName();
            }

            @Override
            public String getQualifiedName(char innerClassDelimiter) {
                return getPackage(e) + "." + e.getName();
            }

            @Override
            public EClass eClass() {
                return e.eClass();
            }

            @Override
            public Resource eResource() {
                return e.eResource();
            }

            @Override
            public EObject eContainer() {
                return e.eContainer();
            }

            @Override
            public EStructuralFeature eContainingFeature() {
                return e.eContainingFeature();
            }

            @Override
            public EReference eContainmentFeature() {
                return e.eContainmentFeature();
            }

            @Override
            public EList<EObject> eContents() {
                return e.eContents();
            }

            @Override
            public TreeIterator<EObject> eAllContents() {
                return e.eAllContents();
            }

            @Override
            public boolean eIsProxy() {
                return e.eIsProxy();
            }

            @Override
            public EList<EObject> eCrossReferences() {
                return e.eCrossReferences();
            }

            @Override
            public Object eGet(EStructuralFeature feature) {
                return e.eGet(feature);
            }

            @Override
            public Object eGet(EStructuralFeature feature, boolean resolve) {
                return e.eGet(feature, resolve);
            }

            @Override
            public void eSet(EStructuralFeature feature, Object newValue) {
                e.eSet(feature, newValue);
            }

            @Override
            public boolean eIsSet(EStructuralFeature feature) {
                return e.eIsSet(feature);
            }

            @Override
            public void eUnset(EStructuralFeature feature) {
                e.eUnset(feature);
            }

            @Override
            public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
                return e.eInvoke(operation, arguments);
            }

            @Override
            public EList<Adapter> eAdapters() {
                return e.eAdapters();
            }

            @Override
            public boolean eDeliver() {
                return e.eDeliver();
            }

            @Override
            public void eSetDeliver(boolean deliver) {
                e.eSetDeliver(deliver);
            }

            @Override
            public void eNotify(Notification notification) {
                e.eNotify(notification);
            }

        };
    }

    public static String _toFirstUpper(String name) {
        int l = name.length();
        if (l == 0)
            return name;
        if (l == 1)
            return name.toUpperCase();
        char c = name.charAt(1);
        if (Character.isUpperCase(c))
            return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static DbType getDbType(DbResolver dbResolver, Artifacts artifacts) {
        DbType dbType = dbResolver.getDatabaseDirectives(artifacts).dbType;
        if (dbType == null) {
            DbType[] dbTypes = DbType.fromDbMetaInfo(dbResolver.getDbMetaInfo(artifacts));
            if (dbTypes != null && dbTypes.length > 0)
                dbType = dbTypes[0];
        }
        return dbType;
    }

    public static String getSuffix(PackageDeclaration p) {
        if (p.getDirectives() == null || p.getDirectives().isEmpty())
            return null;
        for (PackageDirective directive : p.getDirectives()) {
            if (directive instanceof PackageDirectiveSuffix)
                return ((PackageDirectiveSuffix) directive).getSuffix();
        }
        return null;
    }
}
