package org.sqlproc.dsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.sqlproc.dsl.ImportManager;
import org.sqlproc.dsl.processorDsl.AnnotatedEntity;
import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.AnnotationProperty;
import org.sqlproc.dsl.processorDsl.Entity;
import org.sqlproc.dsl.processorDsl.EnumEntity;
import org.sqlproc.dsl.processorDsl.EnumProperty;
import org.sqlproc.dsl.processorDsl.Extends;
import org.sqlproc.dsl.processorDsl.ImplPackage;
import org.sqlproc.dsl.processorDsl.Implements;
import org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.PojoMethod;
import org.sqlproc.dsl.processorDsl.PojoMethodArg;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.PojoType;
import org.sqlproc.dsl.util.Utils;

@SuppressWarnings("all")
public class ProcessorDslGenerator implements IGenerator {
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    TreeIterator<EObject> _allContents = resource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<AnnotatedEntity> _filter = Iterables.<AnnotatedEntity>filter(_iterable, AnnotatedEntity.class);
    for (final AnnotatedEntity e : _filter) {
      EObject _eContainer = e.eContainer();
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
      String _string = _fullyQualifiedName.toString("/");
      String _plus = (_string + "/");
      QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e);
      String _plus_1 = (_plus + _fullyQualifiedName_1);
      String _plus_2 = (_plus_1 + ".java");
      CharSequence _compile = this.compile(e);
      fsa.generateFile(_plus_2, _compile);
    }
    TreeIterator<EObject> _allContents_1 = resource.getAllContents();
    Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_allContents_1);
    Iterable<PojoDao> _filter_1 = Iterables.<PojoDao>filter(_iterable_1, PojoDao.class);
    for (final PojoDao d : _filter_1) {
      String _implPackage = this.getImplPackage(d);
      boolean _notEquals = (!Objects.equal(_implPackage, null));
      if (_notEquals) {
        EObject _eContainer_1 = d.eContainer();
        QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_1);
        String _string_1 = _fullyQualifiedName_2.toString("/");
        String _plus_3 = (_string_1 + "/");
        QualifiedName _fullyQualifiedName_3 = this._iQualifiedNameProvider.getFullyQualifiedName(d);
        String _plus_4 = (_plus_3 + _fullyQualifiedName_3);
        String _plus_5 = (_plus_4 + ".java");
        CharSequence _compileIfx = this.compileIfx(d);
        fsa.generateFile(_plus_5, _compileIfx);
        EObject _eContainer_2 = d.eContainer();
        QualifiedName _fullyQualifiedName_4 = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_2);
        String _string_2 = _fullyQualifiedName_4.toString("/");
        String _plus_6 = (_string_2 + "/");
        String _implPackage_1 = this.getImplPackage(d);
        String _plus_7 = (_plus_6 + _implPackage_1);
        String _plus_8 = (_plus_7 + "/");
        QualifiedName _fullyQualifiedName_5 = this._iQualifiedNameProvider.getFullyQualifiedName(d);
        String _plus_9 = (_plus_8 + _fullyQualifiedName_5);
        String _plus_10 = (_plus_9 + "Impl.java");
        CharSequence _compile_1 = this.compile(d);
        fsa.generateFile(_plus_10, _compile_1);
      } else {
        EObject _eContainer_3 = d.eContainer();
        QualifiedName _fullyQualifiedName_6 = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_3);
        String _string_3 = _fullyQualifiedName_6.toString("/");
        String _plus_11 = (_string_3 + "/");
        QualifiedName _fullyQualifiedName_7 = this._iQualifiedNameProvider.getFullyQualifiedName(d);
        String _plus_12 = (_plus_11 + _fullyQualifiedName_7);
        String _plus_13 = (_plus_12 + ".java");
        CharSequence _compile_2 = this.compile(d);
        fsa.generateFile(_plus_13, _compile_2);
      }
    }
  }
  
  public CharSequence compile(final AnnotatedEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Entity _entity = e.getEntity();
      if ((_entity instanceof EnumEntity)) {
        EnumEntity _enumEntity = Utils.enumEntity(e);
        CharSequence _compile = this.compile(_enumEntity);
        _builder.append(_compile, "");
      }
    }
    {
      Entity _entity_1 = e.getEntity();
      if ((_entity_1 instanceof PojoEntity)) {
        PojoEntity _pojoEntity = Utils.pojoEntity(e);
        CharSequence _compile_1 = this.compile(_pojoEntity, e);
        _builder.append(_compile_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compile(final EnumEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    ImportManager _importManager = new ImportManager(true);
    final ImportManager im = _importManager;
    _builder.newLineIfNotEmpty();
    final EnumProperty eattr = Utils.getEnumAttr(e);
    _builder.newLineIfNotEmpty();
    this.addImplements(e, im);
    _builder.newLineIfNotEmpty();
    this.addExtends(e, im);
    _builder.newLineIfNotEmpty();
    final CharSequence classBody = this.compile(e, im, eattr);
    _builder.newLineIfNotEmpty();
    {
      EObject _eContainer = e.eContainer();
      boolean _notEquals = (!Objects.equal(_eContainer, null));
      if (_notEquals) {
        _builder.append("package ");
        EObject _eContainer_1 = e.eContainer();
        EObject _eContainer_2 = _eContainer_1.eContainer();
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_2);
        _builder.append(_fullyQualifiedName, "");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      List<String> _imports = im.getImports();
      boolean _isEmpty = _imports.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("  ");
        _builder.newLine();
        {
          List<String> _imports_1 = im.getImports();
          for(final String i : _imports_1) {
            _builder.append("import ");
            _builder.append(i, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      String _sernum = Utils.getSernum(e);
      boolean _notEquals_1 = (!Objects.equal(_sernum, null));
      if (_notEquals_1) {
        _builder.newLine();
        _builder.append("import java.io.Serializable;");
        _builder.newLine();
      }
    }
    {
      EList<EnumProperty> _features = e.getFeatures();
      boolean _isEmpty_1 = _features.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("import java.util.HashMap;");
        _builder.newLine();
        _builder.append("import java.util.Map;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append(classBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compile(final EnumEntity e, final ImportManager im, final EnumProperty ea) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    CharSequence _compileImplements = this.compileImplements(e);
    _builder.append(_compileImplements, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("  ");
    {
      EList<EnumProperty> _features = e.getFeatures();
      final Function1<EnumProperty,Boolean> _function = new Function1<EnumProperty,Boolean>() {
          public Boolean apply(final EnumProperty x) {
            String _value = x.getValue();
            boolean _notEquals = (!Objects.equal(_value, null));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<EnumProperty> _filter = IterableExtensions.<EnumProperty>filter(_features, _function);
      boolean _hasElements = false;
      for(final EnumProperty f : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_1 = f.getName();
        _builder.append(_name_1, "  ");
        _builder.append("(");
        String _value = f.getValue();
        _builder.append(_value, "  ");
        _builder.append(")");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      String _sernum = Utils.getSernum(e);
      boolean _notEquals = (!Objects.equal(_sernum, null));
      if (_notEquals) {
        _builder.append("  ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("private static final long serialVersionUID = ");
        String _sernum_1 = Utils.getSernum(e);
        _builder.append(_sernum_1, "  ");
        _builder.append("L;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private static Map<");
    CharSequence _compileType = this.compileType(ea, im);
    _builder.append(_compileType, "  ");
    _builder.append(", ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "  ");
    _builder.append("> identifierMap = new HashMap<");
    CharSequence _compileType_1 = this.compileType(ea, im);
    _builder.append(_compileType_1, "  ");
    _builder.append(", ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "  ");
    _builder.append(">();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("for (");
    String _name_4 = e.getName();
    _builder.append(_name_4, "        ");
    _builder.append(" value : ");
    String _name_5 = e.getName();
    _builder.append(_name_5, "        ");
    _builder.append(".values()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("identifierMap.put(value.getValue(), value);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private ");
    CharSequence _compileType_2 = this.compileType(ea, im);
    _builder.append(_compileType_2, "    ");
    _builder.append(" ");
    String _name_6 = ea.getName();
    _builder.append(_name_6, "    ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private ");
    String _name_7 = e.getName();
    _builder.append(_name_7, "    ");
    _builder.append("(");
    CharSequence _compileType_3 = this.compileType(ea, im);
    _builder.append(_compileType_3, "    ");
    _builder.append(" value) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("this.");
    String _name_8 = ea.getName();
    _builder.append(_name_8, "        ");
    _builder.append(" = value;");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public static ");
    String _name_9 = e.getName();
    _builder.append(_name_9, "    ");
    _builder.append(" fromValue(");
    CharSequence _compileType_4 = this.compileType(ea, im);
    _builder.append(_compileType_4, "    ");
    _builder.append(" value) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    String _name_10 = e.getName();
    _builder.append(_name_10, "        ");
    _builder.append(" result = identifierMap.get(value);");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("if (result == null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("throw new IllegalArgumentException(\"No ");
    String _name_11 = e.getName();
    _builder.append(_name_11, "            ");
    _builder.append(" for value: \" + value);");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    CharSequence _compileType_5 = this.compileType(ea, im);
    _builder.append(_compileType_5, "    ");
    _builder.append(" getValue() {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return ");
    String _name_12 = ea.getName();
    _builder.append(_name_12, "        ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return name();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    ImportManager _importManager = new ImportManager(true);
    final ImportManager im = _importManager;
    _builder.newLineIfNotEmpty();
    this.addImplements(e, im);
    _builder.newLineIfNotEmpty();
    this.addExtends(e, im);
    _builder.newLineIfNotEmpty();
    final CharSequence classBody = this.compile(e, ae, im);
    _builder.newLineIfNotEmpty();
    {
      EObject _eContainer = e.eContainer();
      boolean _notEquals = (!Objects.equal(_eContainer, null));
      if (_notEquals) {
        _builder.append("package ");
        EObject _eContainer_1 = e.eContainer();
        EObject _eContainer_2 = _eContainer_1.eContainer();
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_2);
        _builder.append(_fullyQualifiedName, "");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      List<String> _imports = im.getImports();
      boolean _isEmpty = _imports.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("  ");
        _builder.newLine();
        {
          List<String> _imports_1 = im.getImports();
          for(final String i : _imports_1) {
            _builder.append("import ");
            _builder.append(i, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      String _sernum = Utils.getSernum(e);
      boolean _notEquals_1 = (!Objects.equal(_sernum, null));
      if (_notEquals_1) {
        _builder.newLine();
        _builder.append("import java.io.Serializable;");
        _builder.newLine();
      }
    }
    {
      List<PojoAnnotatedProperty> _listFeatures = this.listFeatures(e);
      boolean _isEmpty_1 = _listFeatures.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("import java.util.ArrayList;");
        _builder.newLine();
      }
    }
    {
      boolean _or = false;
      PojoAnnotatedProperty _hasIsDef = this.hasIsDef(e);
      boolean _notEquals_2 = (!Objects.equal(_hasIsDef, null));
      if (_notEquals_2) {
        _or = true;
      } else {
        PojoAnnotatedProperty _hasToInit = this.hasToInit(e);
        boolean _notEquals_3 = (!Objects.equal(_hasToInit, null));
        _or = (_notEquals_2 || _notEquals_3);
      }
      if (_or) {
        _builder.append("import java.util.Set;");
        _builder.newLine();
        _builder.append("import java.util.HashSet;");
        _builder.newLine();
        _builder.append("import java.lang.reflect.InvocationTargetException;");
        _builder.newLine();
        _builder.append("import org.apache.commons.beanutils.MethodUtils;");
        _builder.newLine();
      }
    }
    {
      boolean _and = false;
      boolean _hasOperators = Utils.hasOperators(e);
      if (!_hasOperators) {
        _and = false;
      } else {
        String _operatorsSuffix = Utils.getOperatorsSuffix(e);
        boolean _equals = Objects.equal(_operatorsSuffix, null);
        _and = (_hasOperators && _equals);
      }
      if (_and) {
        _builder.append("import java.util.Map;");
        _builder.newLine();
        _builder.append("import java.util.HashMap;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append(classBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compile(final PojoEntity e, final AnnotatedEntity ae, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Annotation> _annotations = ae.getAnnotations();
      for(final Annotation a : _annotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements = false;
              for(final AnnotationProperty f : _features_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(f, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    {
      boolean _isAbstract = Utils.isAbstract(e);
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    _builder.append("class ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    CharSequence _compileExtends = this.compileExtends(e, im);
    _builder.append(_compileExtends, "");
    CharSequence _compileImplements = this.compileImplements(e);
    _builder.append(_compileImplements, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      String _sernum = Utils.getSernum(e);
      boolean _notEquals = (!Objects.equal(_sernum, null));
      if (_notEquals) {
        _builder.append("  ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("private static final long serialVersionUID = ");
        String _sernum_1 = Utils.getSernum(e);
        _builder.append(_sernum_1, "  ");
        _builder.append("L;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<PojoAnnotatedProperty> _features_2 = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            String _index = Utils.getIndex(_feature);
            boolean _notEquals = (!Objects.equal(_index, null));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter = IterableExtensions.<PojoAnnotatedProperty>filter(_features_2, _function);
      for(final PojoAnnotatedProperty f_1 : _filter) {
        {
          EList<Annotation> _staticAnnotations = ae.getStaticAnnotations();
          for(final Annotation a_1 : _staticAnnotations) {
            _builder.append("  ");
            _builder.append("@");
            JvmType _type_1 = a_1.getType();
            CharSequence _serialize_1 = im.serialize(_type_1);
            _builder.append(_serialize_1, "  ");
            {
              EList<AnnotationProperty> _features_3 = a_1.getFeatures();
              boolean _isEmpty_1 = _features_3.isEmpty();
              boolean _not_1 = (!_isEmpty_1);
              if (_not_1) {
                _builder.append("(");
                {
                  EList<AnnotationProperty> _features_4 = a_1.getFeatures();
                  boolean _hasElements_1 = false;
                  for(final AnnotationProperty ff : _features_4) {
                    if (!_hasElements_1) {
                      _hasElements_1 = true;
                    } else {
                      _builder.appendImmediate(", ", "  ");
                    }
                    CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(ff, im);
                    _builder.append(_compileAnnotationProperty_1, "  ");
                  }
                }
                _builder.append(")");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("public static final int ORDER_BY_");
        PojoProperty _feature = f_1.getFeature();
        String _constName = Utils.constName(_feature);
        _builder.append(_constName, "  ");
        _builder.append(" = ");
        PojoProperty _feature_1 = f_1.getFeature();
        String _index = Utils.getIndex(_feature_1);
        _builder.append(_index, "  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<PojoAnnotatedProperty> _features_5 = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function_1 = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            String _name = _feature.getName();
            boolean _startsWith = _name.startsWith("index=");
            return Boolean.valueOf(_startsWith);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter_1 = IterableExtensions.<PojoAnnotatedProperty>filter(_features_5, _function_1);
      for(final PojoAnnotatedProperty f_2 : _filter_1) {
        {
          EList<Annotation> _staticAnnotations_1 = ae.getStaticAnnotations();
          for(final Annotation a_2 : _staticAnnotations_1) {
            _builder.append("  ");
            _builder.append("@");
            JvmType _type_2 = a_2.getType();
            CharSequence _serialize_2 = im.serialize(_type_2);
            _builder.append(_serialize_2, "  ");
            {
              EList<AnnotationProperty> _features_6 = a_2.getFeatures();
              boolean _isEmpty_2 = _features_6.isEmpty();
              boolean _not_2 = (!_isEmpty_2);
              if (_not_2) {
                _builder.append("(");
                {
                  EList<AnnotationProperty> _features_7 = a_2.getFeatures();
                  boolean _hasElements_2 = false;
                  for(final AnnotationProperty ff_1 : _features_7) {
                    if (!_hasElements_2) {
                      _hasElements_2 = true;
                    } else {
                      _builder.appendImmediate(", ", "  ");
                    }
                    CharSequence _compileAnnotationProperty_2 = this.compileAnnotationProperty(ff_1, im);
                    _builder.append(_compileAnnotationProperty_2, "  ");
                  }
                }
                _builder.append(")");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("public static final int ORDER_BY_");
        PojoProperty _feature_2 = f_2.getFeature();
        String _constName2 = Utils.constName2(_feature_2);
        _builder.append(_constName2, "  ");
        _builder.append(" = ");
        PojoProperty _feature_3 = f_2.getFeature();
        String _name_1 = _feature_3.getName();
        String _substring = _name_1.substring(6);
        _builder.append(_substring, "  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Annotation> _constructorAnnotations = ae.getConstructorAnnotations();
      for(final Annotation a_3 : _constructorAnnotations) {
        _builder.append("  ");
        _builder.append("@");
        JvmType _type_3 = a_3.getType();
        CharSequence _serialize_3 = im.serialize(_type_3);
        _builder.append(_serialize_3, "  ");
        {
          EList<AnnotationProperty> _features_8 = a_3.getFeatures();
          boolean _isEmpty_3 = _features_8.isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          if (_not_3) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_9 = a_3.getFeatures();
              boolean _hasElements_3 = false;
              for(final AnnotationProperty f_3 : _features_9) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "  ");
                }
                CharSequence _compileAnnotationProperty_3 = this.compileAnnotationProperty(f_3, im);
                _builder.append(_compileAnnotationProperty_3, "  ");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("public ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "  ");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    {
      List<PojoAnnotatedProperty> _requiredFeatures = this.requiredFeatures(e);
      boolean _isEmpty_4 = _requiredFeatures.isEmpty();
      boolean _not_4 = (!_isEmpty_4);
      if (_not_4) {
        _builder.append("  ");
        _builder.newLine();
        {
          EList<Annotation> _constructorAnnotations_1 = ae.getConstructorAnnotations();
          for(final Annotation a_4 : _constructorAnnotations_1) {
            _builder.append("  ");
            _builder.append("@");
            JvmType _type_4 = a_4.getType();
            CharSequence _serialize_4 = im.serialize(_type_4);
            _builder.append(_serialize_4, "  ");
            {
              EList<AnnotationProperty> _features_10 = a_4.getFeatures();
              boolean _isEmpty_5 = _features_10.isEmpty();
              boolean _not_5 = (!_isEmpty_5);
              if (_not_5) {
                _builder.append("(");
                {
                  EList<AnnotationProperty> _features_11 = a_4.getFeatures();
                  boolean _hasElements_4 = false;
                  for(final AnnotationProperty f_4 : _features_11) {
                    if (!_hasElements_4) {
                      _hasElements_4 = true;
                    } else {
                      _builder.appendImmediate(", ", "  ");
                    }
                    CharSequence _compileAnnotationProperty_4 = this.compileAnnotationProperty(f_4, im);
                    _builder.append(_compileAnnotationProperty_4, "  ");
                  }
                }
                _builder.append(")");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("public ");
        String _name_3 = e.getName();
        _builder.append(_name_3, "  ");
        _builder.append("(");
        {
          List<PojoAnnotatedProperty> _requiredFeatures_1 = this.requiredFeatures(e);
          boolean _hasElements_5 = false;
          for(final PojoAnnotatedProperty f_5 : _requiredFeatures_1) {
            if (!_hasElements_5) {
              _hasElements_5 = true;
            } else {
              _builder.appendImmediate(", ", "  ");
            }
            PojoProperty _feature_4 = f_5.getFeature();
            CharSequence _compileType = this.compileType(_feature_4, im);
            CharSequence _fullName = Utils.getFullName(e, f_5, _compileType, im);
            _builder.append(_fullName, "  ");
            _builder.append(" ");
            PojoProperty _feature_5 = f_5.getFeature();
            String _name_4 = _feature_5.getName();
            _builder.append(_name_4, "  ");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        {
          ArrayList<PojoAnnotatedProperty> _requiredSuperFeatures = this.requiredSuperFeatures(e);
          boolean _hasElements_6 = false;
          for(final PojoAnnotatedProperty f_6 : _requiredSuperFeatures) {
            if (!_hasElements_6) {
              _hasElements_6 = true;
              _builder.append("  super(", "  ");
            } else {
              _builder.appendImmediate(", ", "  ");
            }
            PojoProperty _feature_6 = f_6.getFeature();
            String _name_5 = _feature_6.getName();
            _builder.append(_name_5, "  ");
          }
          if (_hasElements_6) {
            _builder.append(");", "  ");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        {
          List<PojoAnnotatedProperty> _requiredFeatures1 = this.requiredFeatures1(e);
          boolean _hasElements_7 = false;
          for(final PojoAnnotatedProperty f_7 : _requiredFeatures1) {
            if (!_hasElements_7) {
              _hasElements_7 = true;
            } else {
              _builder.appendImmediate("\n", "  ");
            }
            _builder.append("  this.");
            PojoProperty _feature_7 = f_7.getFeature();
            String _name_6 = _feature_7.getName();
            _builder.append(_name_6, "  ");
            _builder.append(" = ");
            PojoProperty _feature_8 = f_7.getFeature();
            String _name_7 = _feature_8.getName();
            _builder.append(_name_7, "  ");
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      EList<PojoAnnotatedProperty> _features_12 = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function_2 = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            boolean _isAttribute = ProcessorDslGenerator.this.isAttribute(_feature);
            return Boolean.valueOf(_isAttribute);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter_2 = IterableExtensions.<PojoAnnotatedProperty>filter(_features_12, _function_2);
      for(final PojoAnnotatedProperty f_8 : _filter_2) {
        _builder.append("  ");
        PojoProperty _feature_9 = f_8.getFeature();
        String _operatorsSuffix = Utils.getOperatorsSuffix(e);
        CharSequence _compile = this.compile(_feature_9, f_8, im, e, ae, _operatorsSuffix);
        _builder.append(_compile, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    {
      EList<PojoAnnotatedProperty> _features_13 = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function_3 = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            boolean _isAttribute = ProcessorDslGenerator.this.isAttribute(_feature);
            boolean _not = (!_isAttribute);
            return Boolean.valueOf(_not);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter_3 = IterableExtensions.<PojoAnnotatedProperty>filter(_features_13, _function_3);
      for(final PojoAnnotatedProperty f_9 : _filter_3) {
        {
          PojoProperty _feature_10 = f_9.getFeature();
          String _name_8 = _feature_10.getName();
          boolean _equalsIgnoreCase = _name_8.equalsIgnoreCase("hashCode");
          if (_equalsIgnoreCase) {
            PojoProperty _feature_11 = f_9.getFeature();
            CharSequence _compileHashCode = this.compileHashCode(_feature_11, f_9, im, e, ae);
            _builder.append(_compileHashCode, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
          } else {
            PojoProperty _feature_12 = f_9.getFeature();
            String _name_9 = _feature_12.getName();
            boolean _equalsIgnoreCase_1 = _name_9.equalsIgnoreCase("equals");
            if (_equalsIgnoreCase_1) {
              PojoProperty _feature_13 = f_9.getFeature();
              CharSequence _compileEquals = this.compileEquals(_feature_13, f_9, im, e, ae);
              _builder.append(_compileEquals, "  ");
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
            } else {
              PojoProperty _feature_14 = f_9.getFeature();
              String _name_10 = _feature_14.getName();
              boolean _equalsIgnoreCase_2 = _name_10.equalsIgnoreCase("toInit");
              if (_equalsIgnoreCase_2) {
                PojoProperty _feature_15 = f_9.getFeature();
                CharSequence _compileToInit = this.compileToInit(_feature_15, f_9, im, e, ae);
                _builder.append(_compileToInit, "  ");
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
              } else {
                PojoProperty _feature_16 = f_9.getFeature();
                String _name_11 = _feature_16.getName();
                boolean _equalsIgnoreCase_3 = _name_11.equalsIgnoreCase("enumInit");
                if (_equalsIgnoreCase_3) {
                  PojoProperty _feature_17 = f_9.getFeature();
                  CharSequence _compileEnumInit = this.compileEnumInit(_feature_17, f_9, im, e, ae);
                  _builder.append(_compileEnumInit, "  ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("  ");
                } else {
                  PojoProperty _feature_18 = f_9.getFeature();
                  String _name_12 = _feature_18.getName();
                  boolean _equalsIgnoreCase_4 = _name_12.equalsIgnoreCase("isDef");
                  if (_equalsIgnoreCase_4) {
                    PojoProperty _feature_19 = f_9.getFeature();
                    CharSequence _compileIsDef = this.compileIsDef(_feature_19, f_9, im, e, ae);
                    _builder.append(_compileIsDef, "  ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                  } else {
                    PojoProperty _feature_20 = f_9.getFeature();
                    String _name_13 = _feature_20.getName();
                    boolean _equalsIgnoreCase_5 = _name_13.equalsIgnoreCase("enumDef");
                    if (_equalsIgnoreCase_5) {
                      PojoProperty _feature_21 = f_9.getFeature();
                      CharSequence _compileEnumDef = this.compileEnumDef(_feature_21, f_9, im, e, ae);
                      _builder.append(_compileEnumDef, "  ");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                    } else {
                      PojoProperty _feature_22 = f_9.getFeature();
                      String _name_14 = _feature_22.getName();
                      boolean _equalsIgnoreCase_6 = _name_14.equalsIgnoreCase("toString");
                      if (_equalsIgnoreCase_6) {
                        PojoProperty _feature_23 = f_9.getFeature();
                        CharSequence _compileToString = this.compileToString(_feature_23, f_9, im, e, ae);
                        _builder.append(_compileToString, "  ");
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      boolean _and = false;
      boolean _hasOperators = Utils.hasOperators(e);
      if (!_hasOperators) {
        _and = false;
      } else {
        String _operatorsSuffix_1 = Utils.getOperatorsSuffix(e);
        boolean _equals = Objects.equal(_operatorsSuffix_1, null);
        _and = (_hasOperators && _equals);
      }
      if (_and) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        CharSequence _compileOperators = this.compileOperators(im, e, ae);
        _builder.append(_compileOperators, "  ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileAnnotationProperty(final AnnotationProperty f, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = f.getName();
    _builder.append(_name, "");
    _builder.append(" = ");
    {
      JvmType _type = f.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        JvmType _type_1 = f.getType();
        CharSequence _serialize = im.serialize(_type_1);
        _builder.append(_serialize, "");
      } else {
        PojoEntity _ref = f.getRef();
        boolean _notEquals_1 = (!Objects.equal(_ref, null));
        if (_notEquals_1) {
          PojoEntity _ref_1 = f.getRef();
          QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_ref_1);
          _builder.append(_fullyQualifiedName, "");
        }
      }
    }
    String _annotationValue = Utils.getAnnotationValue(f);
    _builder.append(_annotationValue, "");
    return _builder;
  }
  
  public CharSequence compile(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae, final String operatorSuffix) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("private ");
    CharSequence _compileType = this.compileType(f, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = f.getName();
    _builder.append(_name, "");
    {
      boolean _isList = Utils.isList(f);
      if (_isList) {
        _builder.append(" = new Array");
        CharSequence _compileType_1 = this.compileType(f, im);
        _builder.append(_compileType_1, "");
        _builder.append("()");
      } else {
        boolean _isOptLock = Utils.isOptLock(f);
        if (_isOptLock) {
          _builder.append(" = 0");
        }
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Annotation> _getterAnnotations = aaf.getGetterAnnotations();
      for(final Annotation a_1 : _getterAnnotations) {
        _builder.append("@");
        JvmType _type_1 = a_1.getType();
        CharSequence _serialize_1 = im.serialize(_type_1);
        _builder.append(_serialize_1, "");
        {
          EList<AnnotationProperty> _features_2 = a_1.getFeatures();
          boolean _isEmpty_1 = _features_2.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_3 = a_1.getFeatures();
              boolean _hasElements_1 = false;
              for(final AnnotationProperty af_1 : _features_3) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(af_1, im);
                _builder.append(_compileAnnotationProperty_1, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    CharSequence _compileType_2 = this.compileType(f, im);
    _builder.append(_compileType_2, "");
    _builder.append(" get");
    String _name_1 = f.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_2 = f.getName();
    _builder.append(_name_2, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _setterAnnotations = aaf.getSetterAnnotations();
      for(final Annotation a_2 : _setterAnnotations) {
        _builder.append("@");
        JvmType _type_2 = a_2.getType();
        CharSequence _serialize_2 = im.serialize(_type_2);
        _builder.append(_serialize_2, "");
        {
          EList<AnnotationProperty> _features_4 = a_2.getFeatures();
          boolean _isEmpty_2 = _features_4.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_5 = a_2.getFeatures();
              boolean _hasElements_2 = false;
              for(final AnnotationProperty af_2 : _features_5) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_2 = this.compileAnnotationProperty(af_2, im);
                _builder.append(_compileAnnotationProperty_2, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void set");
    String _name_3 = f.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_1, "");
    _builder.append("(");
    CharSequence _compileType_3 = this.compileType(f, im);
    _builder.append(_compileType_3, "");
    _builder.append(" ");
    String _name_4 = f.getName();
    _builder.append(_name_4, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("this.");
    String _name_5 = f.getName();
    _builder.append(_name_5, "  ");
    _builder.append(" = ");
    String _name_6 = f.getName();
    _builder.append(_name_6, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      String _updateColumn1 = Utils.getUpdateColumn1(f);
      boolean _notEquals = (!Objects.equal(_updateColumn1, null));
      if (_notEquals) {
        _builder.append("  ");
        _builder.append("if (this.");
        String _name_7 = f.getName();
        _builder.append(_name_7, "  ");
        _builder.append(" != null)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("this.");
        String _updateColumn2 = Utils.getUpdateColumn2(f);
        _builder.append(_updateColumn2, "    ");
        _builder.append(" = this.");
        String _name_8 = f.getName();
        _builder.append(_name_8, "    ");
        _builder.append(".get");
        String _updateColumn1_1 = Utils.getUpdateColumn1(f);
        String _firstUpper_2 = StringExtensions.toFirstUpper(_updateColumn1_1);
        _builder.append(_firstUpper_2, "    ");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      String _createColumn1 = Utils.getCreateColumn1(f);
      boolean _notEquals_1 = (!Objects.equal(_createColumn1, null));
      if (_notEquals_1) {
        _builder.append("  ");
        _builder.append("if (this.");
        String _createColumn1_1 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_1, "  ");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("this.");
        String _createColumn1_2 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_2, "      ");
        _builder.append(" = new ");
        String _createColumn1_3 = Utils.getCreateColumn1(f);
        PojoProperty _attribute = Utils.getAttribute(e, _createColumn1_3);
        CharSequence _compileType_4 = this.compileType(_attribute, im);
        _builder.append(_compileType_4, "      ");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("this.");
        String _createColumn1_4 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_4, "  ");
        _builder.append(".set");
        String _createColumn2 = Utils.getCreateColumn2(f);
        String _firstUpper_3 = StringExtensions.toFirstUpper(_createColumn2);
        _builder.append(_firstUpper_3, "  ");
        _builder.append("(");
        String _name_9 = f.getName();
        _builder.append(_name_9, "  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_10 = e.getName();
    _builder.append(_name_10, "");
    _builder.append(" _set");
    String _name_11 = f.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_11);
    _builder.append(_firstUpper_4, "");
    _builder.append("(");
    CharSequence _compileType_5 = this.compileType(f, im);
    _builder.append(_compileType_5, "");
    _builder.append(" ");
    String _name_12 = f.getName();
    _builder.append(_name_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("this.");
    String _name_13 = f.getName();
    _builder.append(_name_13, "  ");
    _builder.append(" = ");
    String _name_14 = f.getName();
    _builder.append(_name_14, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      String _updateColumn1_2 = Utils.getUpdateColumn1(f);
      boolean _notEquals_2 = (!Objects.equal(_updateColumn1_2, null));
      if (_notEquals_2) {
        _builder.append("  ");
        _builder.append("if (this.");
        String _name_15 = f.getName();
        _builder.append(_name_15, "  ");
        _builder.append(" != null)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("this.");
        String _updateColumn2_1 = Utils.getUpdateColumn2(f);
        _builder.append(_updateColumn2_1, "    ");
        _builder.append(" = this.");
        String _name_16 = f.getName();
        _builder.append(_name_16, "    ");
        _builder.append(".get");
        String _updateColumn1_3 = Utils.getUpdateColumn1(f);
        String _firstUpper_5 = StringExtensions.toFirstUpper(_updateColumn1_3);
        _builder.append(_firstUpper_5, "    ");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      String _createColumn1_5 = Utils.getCreateColumn1(f);
      boolean _notEquals_3 = (!Objects.equal(_createColumn1_5, null));
      if (_notEquals_3) {
        _builder.append("  ");
        _builder.append("if (this.");
        String _createColumn1_6 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_6, "  ");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("this.");
        String _createColumn1_7 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_7, "      ");
        _builder.append(" = new ");
        String _createColumn1_8 = Utils.getCreateColumn1(f);
        PojoProperty _attribute_1 = Utils.getAttribute(e, _createColumn1_8);
        CharSequence _compileType_6 = this.compileType(_attribute_1, im);
        _builder.append(_compileType_6, "      ");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("this.");
        String _createColumn1_9 = Utils.getCreateColumn1(f);
        _builder.append(_createColumn1_9, "  ");
        _builder.append(".set");
        String _createColumn2_1 = Utils.getCreateColumn2(f);
        String _firstUpper_6 = StringExtensions.toFirstUpper(_createColumn2_1);
        _builder.append(_firstUpper_6, "  ");
        _builder.append("(");
        String _name_17 = f.getName();
        _builder.append(_name_17, "  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    {
      boolean _and = false;
      boolean _hasOperators = Utils.hasOperators(e);
      if (!_hasOperators) {
        _and = false;
      } else {
        boolean _notEquals_4 = (!Objects.equal(operatorSuffix, null));
        _and = (_hasOperators && _notEquals_4);
      }
      if (_and) {
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("private String ");
        String _name_18 = f.getName();
        _builder.append(_name_18, "");
        _builder.append(operatorSuffix, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("public String get");
        String _name_19 = f.getName();
        String _firstUpper_7 = StringExtensions.toFirstUpper(_name_19);
        _builder.append(_firstUpper_7, "");
        _builder.append(operatorSuffix, "");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("return ");
        String _name_20 = f.getName();
        _builder.append(_name_20, "  ");
        _builder.append(operatorSuffix, "  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public void set");
        String _name_21 = f.getName();
        String _firstUpper_8 = StringExtensions.toFirstUpper(_name_21);
        _builder.append(_firstUpper_8, "");
        _builder.append(operatorSuffix, "");
        _builder.append("(String ");
        String _name_22 = f.getName();
        _builder.append(_name_22, "");
        _builder.append(operatorSuffix, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("this.");
        String _name_23 = f.getName();
        _builder.append(_name_23, "  ");
        _builder.append(operatorSuffix, "  ");
        _builder.append(" = ");
        String _name_24 = f.getName();
        _builder.append(_name_24, "  ");
        _builder.append(operatorSuffix, "  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public ");
        String _name_25 = e.getName();
        _builder.append(_name_25, "");
        _builder.append(" _set");
        String _name_26 = f.getName();
        String _firstUpper_9 = StringExtensions.toFirstUpper(_name_26);
        _builder.append(_firstUpper_9, "");
        _builder.append(operatorSuffix, "");
        _builder.append("(String ");
        String _name_27 = f.getName();
        _builder.append(_name_27, "");
        _builder.append(operatorSuffix, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("this.");
        String _name_28 = f.getName();
        _builder.append(_name_28, "  ");
        _builder.append(operatorSuffix, "  ");
        _builder.append(" = ");
        String _name_29 = f.getName();
        _builder.append(_name_29, "  ");
        _builder.append(operatorSuffix, "  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("return this;");
        _builder.newLine();
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileHashCode(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public int hashCode() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("final int prime = 31;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("int result = 1;");
    _builder.newLine();
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      for(final PojoProperty f2 : _attrs) {
        _builder.append("  ");
        _builder.append("result = prime * result + ");
        {
          String _native = f2.getNative();
          boolean _notEquals = (!Objects.equal(_native, null));
          if (_notEquals) {
            _builder.append("(int) (");
            String _name = f2.getName();
            _builder.append(_name, "  ");
            _builder.append(" ^ (");
            String _name_1 = f2.getName();
            _builder.append(_name_1, "  ");
            _builder.append(" >>> 32))");
          } else {
            _builder.append("((");
            String _name_2 = f2.getName();
            _builder.append(_name_2, "  ");
            _builder.append(" != null) ? ");
            String _name_3 = f2.getName();
            _builder.append(_name_3, "  ");
            _builder.append(".hashCode() : 0)");
          }
        }
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("}  ");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileEquals(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public boolean equals(Object obj) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (this == obj)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (obj == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (getClass() != obj.getClass())");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("  ");
    String _name = e.getName();
    _builder.append(_name, "  ");
    _builder.append(" other = (");
    String _name_1 = e.getName();
    _builder.append(_name_1, "  ");
    _builder.append(") obj;");
    _builder.newLineIfNotEmpty();
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      for(final PojoProperty f2 : _attrs) {
        _builder.append("  ");
        {
          String _native = f2.getNative();
          boolean _notEquals = (!Objects.equal(_native, null));
          if (_notEquals) {
            _builder.append("if (");
            String _name_2 = f2.getName();
            _builder.append(_name_2, "  ");
            _builder.append(" != other.");
            String _name_3 = f2.getName();
            _builder.append(_name_3, "  ");
            _builder.append(")");
          } else {
            _builder.append("if (");
            String _name_4 = f2.getName();
            _builder.append(_name_4, "  ");
            _builder.append(" == null || !");
            String _name_5 = f2.getName();
            _builder.append(_name_5, "  ");
            _builder.append(".equals(other.");
            String _name_6 = f2.getName();
            _builder.append(_name_6, "  ");
            _builder.append("))");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("return false;");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("}  ");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileToString(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public String toString() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return \"");
    String _name = e.getName();
    _builder.append(_name, "  ");
    _builder.append(" [");
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      boolean _hasElements_1 = false;
      for(final PojoProperty f2 : _attrs) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" + \", ", "  ");
        }
        String _name_1 = f2.getName();
        _builder.append(_name_1, "  ");
        _builder.append("=\" + ");
        String _name_2 = f2.getName();
        _builder.append(_name_2, "  ");
      }
    }
    {
      PojoEntity _superType = Utils.getSuperType(e);
      boolean _notEquals = (!Objects.equal(_superType, null));
      if (_notEquals) {
        _builder.append(" + super.toString()");
      }
    }
    _builder.append(" + \"]\";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_1 = aaf.getAttributeAnnotations();
      for(final Annotation a_1 : _attributeAnnotations_1) {
        _builder.append("@");
        JvmType _type_1 = a_1.getType();
        CharSequence _serialize_1 = im.serialize(_type_1);
        _builder.append(_serialize_1, "");
        {
          EList<AnnotationProperty> _features_2 = a_1.getFeatures();
          boolean _isEmpty_1 = _features_2.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_3 = a_1.getFeatures();
              boolean _hasElements_2 = false;
              for(final AnnotationProperty af_1 : _features_3) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(af_1, im);
                _builder.append(_compileAnnotationProperty_1, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public String toStringFull() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return \"");
    String _name_3 = e.getName();
    _builder.append(_name_3, "  ");
    _builder.append(" [");
    {
      EList<PojoAnnotatedProperty> _features_4 = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            boolean _isAttribute = ProcessorDslGenerator.this.isAttribute(_feature);
            return Boolean.valueOf(_isAttribute);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter = IterableExtensions.<PojoAnnotatedProperty>filter(_features_4, _function);
      boolean _hasElements_3 = false;
      for(final PojoAnnotatedProperty f2_1 : _filter) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(" + \", ", "  ");
        }
        PojoProperty _feature = f2_1.getFeature();
        String _name_4 = _feature.getName();
        _builder.append(_name_4, "  ");
        _builder.append("=\" + ");
        PojoProperty _feature_1 = f2_1.getFeature();
        String _name_5 = _feature_1.getName();
        _builder.append(_name_5, "  ");
      }
    }
    {
      PojoEntity _superType_1 = Utils.getSuperType(e);
      boolean _notEquals_1 = (!Objects.equal(_superType_1, null));
      if (_notEquals_1) {
        _builder.append(" + super.toString()");
      }
    }
    _builder.append(" + \"]\";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileIsDef(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public enum Attribute {");
    _builder.newLine();
    _builder.append("  ");
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      boolean _hasElements = false;
      for(final PojoProperty f2 : _attrs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name = f2.getName();
        _builder.append(_name, "  ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements_1 = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("private Set<String> nullValues = new HashSet<String>();");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_1 = aaf.getAttributeAnnotations();
      for(final Annotation a_1 : _attributeAnnotations_1) {
        _builder.append("@");
        JvmType _type_1 = a_1.getType();
        CharSequence _serialize_1 = im.serialize(_type_1);
        _builder.append(_serialize_1, "");
        {
          EList<AnnotationProperty> _features_2 = a_1.getFeatures();
          boolean _isEmpty_1 = _features_2.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_3 = a_1.getFeatures();
              boolean _hasElements_2 = false;
              for(final AnnotationProperty af_1 : _features_3) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(af_1, im);
                _builder.append(_compileAnnotationProperty_1, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations = ae.getConflictAnnotations();
      for(final Annotation a_2 : _conflictAnnotations) {
        _builder.append("@");
        JvmType _type_2 = a_2.getType();
        CharSequence _serialize_2 = im.serialize(_type_2);
        _builder.append(_serialize_2, "");
        {
          EList<AnnotationProperty> _features_4 = a_2.getFeatures();
          boolean _isEmpty_2 = _features_4.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_5 = a_2.getFeatures();
              boolean _hasElements_3 = false;
              for(final AnnotationProperty ff : _features_5) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_2 = this.compileAnnotationProperty(ff, im);
                _builder.append(_compileAnnotationProperty_2, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setNull(Attribute... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (Attribute attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("nullValues.add(attribute.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_2 = aaf.getAttributeAnnotations();
      for(final Annotation a_3 : _attributeAnnotations_2) {
        _builder.append("@");
        JvmType _type_3 = a_3.getType();
        CharSequence _serialize_3 = im.serialize(_type_3);
        _builder.append(_serialize_3, "");
        {
          EList<AnnotationProperty> _features_6 = a_3.getFeatures();
          boolean _isEmpty_3 = _features_6.isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          if (_not_3) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_7 = a_3.getFeatures();
              boolean _hasElements_4 = false;
              for(final AnnotationProperty af_2 : _features_7) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_3 = this.compileAnnotationProperty(af_2, im);
                _builder.append(_compileAnnotationProperty_3, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_1 = ae.getConflictAnnotations();
      for(final Annotation a_4 : _conflictAnnotations_1) {
        _builder.append("@");
        JvmType _type_4 = a_4.getType();
        CharSequence _serialize_4 = im.serialize(_type_4);
        _builder.append(_serialize_4, "");
        {
          EList<AnnotationProperty> _features_8 = a_4.getFeatures();
          boolean _isEmpty_4 = _features_8.isEmpty();
          boolean _not_4 = (!_isEmpty_4);
          if (_not_4) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_9 = a_4.getFeatures();
              boolean _hasElements_5 = false;
              for(final AnnotationProperty ff_1 : _features_9) {
                if (!_hasElements_5) {
                  _hasElements_5 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_4 = this.compileAnnotationProperty(ff_1, im);
                _builder.append(_compileAnnotationProperty_4, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" _setNull(Attribute... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setNull(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_3 = aaf.getAttributeAnnotations();
      for(final Annotation a_5 : _attributeAnnotations_3) {
        _builder.append("@");
        JvmType _type_5 = a_5.getType();
        CharSequence _serialize_5 = im.serialize(_type_5);
        _builder.append(_serialize_5, "");
        {
          EList<AnnotationProperty> _features_10 = a_5.getFeatures();
          boolean _isEmpty_5 = _features_10.isEmpty();
          boolean _not_5 = (!_isEmpty_5);
          if (_not_5) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_11 = a_5.getFeatures();
              boolean _hasElements_6 = false;
              for(final AnnotationProperty af_3 : _features_11) {
                if (!_hasElements_6) {
                  _hasElements_6 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_5 = this.compileAnnotationProperty(af_3, im);
                _builder.append(_compileAnnotationProperty_5, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_2 = ae.getConflictAnnotations();
      for(final Annotation a_6 : _conflictAnnotations_2) {
        _builder.append("@");
        JvmType _type_6 = a_6.getType();
        CharSequence _serialize_6 = im.serialize(_type_6);
        _builder.append(_serialize_6, "");
        {
          EList<AnnotationProperty> _features_12 = a_6.getFeatures();
          boolean _isEmpty_6 = _features_12.isEmpty();
          boolean _not_6 = (!_isEmpty_6);
          if (_not_6) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_13 = a_6.getFeatures();
              boolean _hasElements_7 = false;
              for(final AnnotationProperty ff_2 : _features_13) {
                if (!_hasElements_7) {
                  _hasElements_7 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_6 = this.compileAnnotationProperty(ff_2, im);
                _builder.append(_compileAnnotationProperty_6, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearNull(Attribute... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (Attribute attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("nullValues.remove(attribute.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_4 = aaf.getAttributeAnnotations();
      for(final Annotation a_7 : _attributeAnnotations_4) {
        _builder.append("@");
        JvmType _type_7 = a_7.getType();
        CharSequence _serialize_7 = im.serialize(_type_7);
        _builder.append(_serialize_7, "");
        {
          EList<AnnotationProperty> _features_14 = a_7.getFeatures();
          boolean _isEmpty_7 = _features_14.isEmpty();
          boolean _not_7 = (!_isEmpty_7);
          if (_not_7) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_15 = a_7.getFeatures();
              boolean _hasElements_8 = false;
              for(final AnnotationProperty af_4 : _features_15) {
                if (!_hasElements_8) {
                  _hasElements_8 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_7 = this.compileAnnotationProperty(af_4, im);
                _builder.append(_compileAnnotationProperty_7, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_3 = ae.getConflictAnnotations();
      for(final Annotation a_8 : _conflictAnnotations_3) {
        _builder.append("@");
        JvmType _type_8 = a_8.getType();
        CharSequence _serialize_8 = im.serialize(_type_8);
        _builder.append(_serialize_8, "");
        {
          EList<AnnotationProperty> _features_16 = a_8.getFeatures();
          boolean _isEmpty_8 = _features_16.isEmpty();
          boolean _not_8 = (!_isEmpty_8);
          if (_not_8) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_17 = a_8.getFeatures();
              boolean _hasElements_9 = false;
              for(final AnnotationProperty ff_3 : _features_17) {
                if (!_hasElements_9) {
                  _hasElements_9 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_8 = this.compileAnnotationProperty(ff_3, im);
                _builder.append(_compileAnnotationProperty_8, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" _clearNull(Attribute... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearNull(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_5 = aaf.getAttributeAnnotations();
      for(final Annotation a_9 : _attributeAnnotations_5) {
        _builder.append("@");
        JvmType _type_9 = a_9.getType();
        CharSequence _serialize_9 = im.serialize(_type_9);
        _builder.append(_serialize_9, "");
        {
          EList<AnnotationProperty> _features_18 = a_9.getFeatures();
          boolean _isEmpty_9 = _features_18.isEmpty();
          boolean _not_9 = (!_isEmpty_9);
          if (_not_9) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_19 = a_9.getFeatures();
              boolean _hasElements_10 = false;
              for(final AnnotationProperty af_5 : _features_19) {
                if (!_hasElements_10) {
                  _hasElements_10 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_9 = this.compileAnnotationProperty(af_5, im);
                _builder.append(_compileAnnotationProperty_9, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setNull(String... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("nullValues.add(attribute);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_6 = aaf.getAttributeAnnotations();
      for(final Annotation a_10 : _attributeAnnotations_6) {
        _builder.append("@");
        JvmType _type_10 = a_10.getType();
        CharSequence _serialize_10 = im.serialize(_type_10);
        _builder.append(_serialize_10, "");
        {
          EList<AnnotationProperty> _features_20 = a_10.getFeatures();
          boolean _isEmpty_10 = _features_20.isEmpty();
          boolean _not_10 = (!_isEmpty_10);
          if (_not_10) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_21 = a_10.getFeatures();
              boolean _hasElements_11 = false;
              for(final AnnotationProperty af_6 : _features_21) {
                if (!_hasElements_11) {
                  _hasElements_11 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_10 = this.compileAnnotationProperty(af_6, im);
                _builder.append(_compileAnnotationProperty_10, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append(" _setNull(String... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setNull(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_7 = aaf.getAttributeAnnotations();
      for(final Annotation a_11 : _attributeAnnotations_7) {
        _builder.append("@");
        JvmType _type_11 = a_11.getType();
        CharSequence _serialize_11 = im.serialize(_type_11);
        _builder.append(_serialize_11, "");
        {
          EList<AnnotationProperty> _features_22 = a_11.getFeatures();
          boolean _isEmpty_11 = _features_22.isEmpty();
          boolean _not_11 = (!_isEmpty_11);
          if (_not_11) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_23 = a_11.getFeatures();
              boolean _hasElements_12 = false;
              for(final AnnotationProperty af_7 : _features_23) {
                if (!_hasElements_12) {
                  _hasElements_12 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_11 = this.compileAnnotationProperty(af_7, im);
                _builder.append(_compileAnnotationProperty_11, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearNull(String... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("nullValues.remove(attribute);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_8 = aaf.getAttributeAnnotations();
      for(final Annotation a_12 : _attributeAnnotations_8) {
        _builder.append("@");
        JvmType _type_12 = a_12.getType();
        CharSequence _serialize_12 = im.serialize(_type_12);
        _builder.append(_serialize_12, "");
        {
          EList<AnnotationProperty> _features_24 = a_12.getFeatures();
          boolean _isEmpty_12 = _features_24.isEmpty();
          boolean _not_12 = (!_isEmpty_12);
          if (_not_12) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_25 = a_12.getFeatures();
              boolean _hasElements_13 = false;
              for(final AnnotationProperty af_8 : _features_25) {
                if (!_hasElements_13) {
                  _hasElements_13 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_12 = this.compileAnnotationProperty(af_8, im);
                _builder.append(_compileAnnotationProperty_12, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" _clearNull(String... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearNull(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_9 = aaf.getAttributeAnnotations();
      for(final Annotation a_13 : _attributeAnnotations_9) {
        _builder.append("@");
        JvmType _type_13 = a_13.getType();
        CharSequence _serialize_13 = im.serialize(_type_13);
        _builder.append(_serialize_13, "");
        {
          EList<AnnotationProperty> _features_26 = a_13.getFeatures();
          boolean _isEmpty_13 = _features_26.isEmpty();
          boolean _not_13 = (!_isEmpty_13);
          if (_not_13) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_27 = a_13.getFeatures();
              boolean _hasElements_14 = false;
              for(final AnnotationProperty af_9 : _features_27) {
                if (!_hasElements_14) {
                  _hasElements_14 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_13 = this.compileAnnotationProperty(af_9, im);
                _builder.append(_compileAnnotationProperty_13, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public Boolean isNull(String attrName) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attrName == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return nullValues.contains(attrName);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_10 = aaf.getAttributeAnnotations();
      for(final Annotation a_14 : _attributeAnnotations_10) {
        _builder.append("@");
        JvmType _type_14 = a_14.getType();
        CharSequence _serialize_14 = im.serialize(_type_14);
        _builder.append(_serialize_14, "");
        {
          EList<AnnotationProperty> _features_28 = a_14.getFeatures();
          boolean _isEmpty_14 = _features_28.isEmpty();
          boolean _not_14 = (!_isEmpty_14);
          if (_not_14) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_29 = a_14.getFeatures();
              boolean _hasElements_15 = false;
              for(final AnnotationProperty af_10 : _features_29) {
                if (!_hasElements_15) {
                  _hasElements_15 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_14 = this.compileAnnotationProperty(af_10, im);
                _builder.append(_compileAnnotationProperty_14, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_4 = ae.getConflictAnnotations();
      for(final Annotation a_15 : _conflictAnnotations_4) {
        _builder.append("@");
        JvmType _type_15 = a_15.getType();
        CharSequence _serialize_15 = im.serialize(_type_15);
        _builder.append(_serialize_15, "");
        {
          EList<AnnotationProperty> _features_30 = a_15.getFeatures();
          boolean _isEmpty_15 = _features_30.isEmpty();
          boolean _not_15 = (!_isEmpty_15);
          if (_not_15) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_31 = a_15.getFeatures();
              boolean _hasElements_16 = false;
              for(final AnnotationProperty ff_4 : _features_31) {
                if (!_hasElements_16) {
                  _hasElements_16 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_15 = this.compileAnnotationProperty(ff_4, im);
                _builder.append(_compileAnnotationProperty_15, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public Boolean isNull(Attribute attribute) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attribute == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return nullValues.contains(attribute.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_11 = aaf.getAttributeAnnotations();
      for(final Annotation a_16 : _attributeAnnotations_11) {
        _builder.append("@");
        JvmType _type_16 = a_16.getType();
        CharSequence _serialize_16 = im.serialize(_type_16);
        _builder.append(_serialize_16, "");
        {
          EList<AnnotationProperty> _features_32 = a_16.getFeatures();
          boolean _isEmpty_16 = _features_32.isEmpty();
          boolean _not_16 = (!_isEmpty_16);
          if (_not_16) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_33 = a_16.getFeatures();
              boolean _hasElements_17 = false;
              for(final AnnotationProperty af_11 : _features_33) {
                if (!_hasElements_17) {
                  _hasElements_17 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_16 = this.compileAnnotationProperty(af_11, im);
                _builder.append(_compileAnnotationProperty_16, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public Boolean isDef(String attrName) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attrName == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (nullValues.contains(attrName))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Object result = MethodUtils.invokeMethod(this, \"get\" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1, attrName.length()), null);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (result != null) ? true : false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (NoSuchMethodException e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (IllegalAccessException e) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (InvocationTargetException e) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Object result = MethodUtils.invokeMethod(this, \"is\" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1, attrName.length()), null);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (result != null) ? true : false;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (NoSuchMethodException e) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (IllegalAccessException e) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} catch (InvocationTargetException e) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_12 = aaf.getAttributeAnnotations();
      for(final Annotation a_17 : _attributeAnnotations_12) {
        _builder.append("@");
        JvmType _type_17 = a_17.getType();
        CharSequence _serialize_17 = im.serialize(_type_17);
        _builder.append(_serialize_17, "");
        {
          EList<AnnotationProperty> _features_34 = a_17.getFeatures();
          boolean _isEmpty_17 = _features_34.isEmpty();
          boolean _not_17 = (!_isEmpty_17);
          if (_not_17) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_35 = a_17.getFeatures();
              boolean _hasElements_18 = false;
              for(final AnnotationProperty af_12 : _features_35) {
                if (!_hasElements_18) {
                  _hasElements_18 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_17 = this.compileAnnotationProperty(af_12, im);
                _builder.append(_compileAnnotationProperty_17, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearAllNull() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("nullValues = new HashSet<String>();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileEnumDef(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public enum Attribute {");
    _builder.newLine();
    _builder.append("  ");
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      boolean _hasElements = false;
      for(final PojoProperty f2 : _attrs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name = f2.getName();
        _builder.append(_name, "  ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileToInit(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public enum Association {");
    _builder.newLine();
    _builder.append("  ");
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      boolean _hasElements = false;
      for(final PojoProperty f2 : _attrs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name = f2.getName();
        _builder.append(_name, "  ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations = aaf.getAttributeAnnotations();
      for(final Annotation a : _attributeAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features = a.getFeatures();
          boolean _isEmpty = _features.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_1 = a.getFeatures();
              boolean _hasElements_1 = false;
              for(final AnnotationProperty af : _features_1) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(af, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("private Set<String> initAssociations = new HashSet<String>();");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_1 = aaf.getAttributeAnnotations();
      for(final Annotation a_1 : _attributeAnnotations_1) {
        _builder.append("@");
        JvmType _type_1 = a_1.getType();
        CharSequence _serialize_1 = im.serialize(_type_1);
        _builder.append(_serialize_1, "");
        {
          EList<AnnotationProperty> _features_2 = a_1.getFeatures();
          boolean _isEmpty_1 = _features_2.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_3 = a_1.getFeatures();
              boolean _hasElements_2 = false;
              for(final AnnotationProperty af_1 : _features_3) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(af_1, im);
                _builder.append(_compileAnnotationProperty_1, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations = ae.getConflictAnnotations();
      for(final Annotation a_2 : _conflictAnnotations) {
        _builder.append("@");
        JvmType _type_2 = a_2.getType();
        CharSequence _serialize_2 = im.serialize(_type_2);
        _builder.append(_serialize_2, "");
        {
          EList<AnnotationProperty> _features_4 = a_2.getFeatures();
          boolean _isEmpty_2 = _features_4.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_5 = a_2.getFeatures();
              boolean _hasElements_3 = false;
              for(final AnnotationProperty ff : _features_5) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_2 = this.compileAnnotationProperty(ff, im);
                _builder.append(_compileAnnotationProperty_2, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setInit(Association... associations) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (associations == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (Association association : associations)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initAssociations.add(association.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_2 = aaf.getAttributeAnnotations();
      for(final Annotation a_3 : _attributeAnnotations_2) {
        _builder.append("@");
        JvmType _type_3 = a_3.getType();
        CharSequence _serialize_3 = im.serialize(_type_3);
        _builder.append(_serialize_3, "");
        {
          EList<AnnotationProperty> _features_6 = a_3.getFeatures();
          boolean _isEmpty_3 = _features_6.isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          if (_not_3) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_7 = a_3.getFeatures();
              boolean _hasElements_4 = false;
              for(final AnnotationProperty af_2 : _features_7) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_3 = this.compileAnnotationProperty(af_2, im);
                _builder.append(_compileAnnotationProperty_3, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_1 = ae.getConflictAnnotations();
      for(final Annotation a_4 : _conflictAnnotations_1) {
        _builder.append("@");
        JvmType _type_4 = a_4.getType();
        CharSequence _serialize_4 = im.serialize(_type_4);
        _builder.append(_serialize_4, "");
        {
          EList<AnnotationProperty> _features_8 = a_4.getFeatures();
          boolean _isEmpty_4 = _features_8.isEmpty();
          boolean _not_4 = (!_isEmpty_4);
          if (_not_4) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_9 = a_4.getFeatures();
              boolean _hasElements_5 = false;
              for(final AnnotationProperty ff_1 : _features_9) {
                if (!_hasElements_5) {
                  _hasElements_5 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_4 = this.compileAnnotationProperty(ff_1, im);
                _builder.append(_compileAnnotationProperty_4, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append("  _setInit(Association... associations) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setInit(associations);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_3 = aaf.getAttributeAnnotations();
      for(final Annotation a_5 : _attributeAnnotations_3) {
        _builder.append("@");
        JvmType _type_5 = a_5.getType();
        CharSequence _serialize_5 = im.serialize(_type_5);
        _builder.append(_serialize_5, "");
        {
          EList<AnnotationProperty> _features_10 = a_5.getFeatures();
          boolean _isEmpty_5 = _features_10.isEmpty();
          boolean _not_5 = (!_isEmpty_5);
          if (_not_5) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_11 = a_5.getFeatures();
              boolean _hasElements_6 = false;
              for(final AnnotationProperty af_3 : _features_11) {
                if (!_hasElements_6) {
                  _hasElements_6 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_5 = this.compileAnnotationProperty(af_3, im);
                _builder.append(_compileAnnotationProperty_5, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_2 = ae.getConflictAnnotations();
      for(final Annotation a_6 : _conflictAnnotations_2) {
        _builder.append("@");
        JvmType _type_6 = a_6.getType();
        CharSequence _serialize_6 = im.serialize(_type_6);
        _builder.append(_serialize_6, "");
        {
          EList<AnnotationProperty> _features_12 = a_6.getFeatures();
          boolean _isEmpty_6 = _features_12.isEmpty();
          boolean _not_6 = (!_isEmpty_6);
          if (_not_6) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_13 = a_6.getFeatures();
              boolean _hasElements_7 = false;
              for(final AnnotationProperty ff_2 : _features_13) {
                if (!_hasElements_7) {
                  _hasElements_7 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_6 = this.compileAnnotationProperty(ff_2, im);
                _builder.append(_compileAnnotationProperty_6, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearInit(Association... associations) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (associations == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (Association association : associations)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initAssociations.remove(association.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_4 = aaf.getAttributeAnnotations();
      for(final Annotation a_7 : _attributeAnnotations_4) {
        _builder.append("@");
        JvmType _type_7 = a_7.getType();
        CharSequence _serialize_7 = im.serialize(_type_7);
        _builder.append(_serialize_7, "");
        {
          EList<AnnotationProperty> _features_14 = a_7.getFeatures();
          boolean _isEmpty_7 = _features_14.isEmpty();
          boolean _not_7 = (!_isEmpty_7);
          if (_not_7) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_15 = a_7.getFeatures();
              boolean _hasElements_8 = false;
              for(final AnnotationProperty af_4 : _features_15) {
                if (!_hasElements_8) {
                  _hasElements_8 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_7 = this.compileAnnotationProperty(af_4, im);
                _builder.append(_compileAnnotationProperty_7, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Annotation> _conflictAnnotations_3 = ae.getConflictAnnotations();
      for(final Annotation a_8 : _conflictAnnotations_3) {
        _builder.append("@");
        JvmType _type_8 = a_8.getType();
        CharSequence _serialize_8 = im.serialize(_type_8);
        _builder.append(_serialize_8, "");
        {
          EList<AnnotationProperty> _features_16 = a_8.getFeatures();
          boolean _isEmpty_8 = _features_16.isEmpty();
          boolean _not_8 = (!_isEmpty_8);
          if (_not_8) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_17 = a_8.getFeatures();
              boolean _hasElements_9 = false;
              for(final AnnotationProperty ff_3 : _features_17) {
                if (!_hasElements_9) {
                  _hasElements_9 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_8 = this.compileAnnotationProperty(ff_3, im);
                _builder.append(_compileAnnotationProperty_8, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" _clearInit(Association... associations) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearInit(associations);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_5 = aaf.getAttributeAnnotations();
      for(final Annotation a_9 : _attributeAnnotations_5) {
        _builder.append("@");
        JvmType _type_9 = a_9.getType();
        CharSequence _serialize_9 = im.serialize(_type_9);
        _builder.append(_serialize_9, "");
        {
          EList<AnnotationProperty> _features_18 = a_9.getFeatures();
          boolean _isEmpty_9 = _features_18.isEmpty();
          boolean _not_9 = (!_isEmpty_9);
          if (_not_9) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_19 = a_9.getFeatures();
              boolean _hasElements_10 = false;
              for(final AnnotationProperty af_5 : _features_19) {
                if (!_hasElements_10) {
                  _hasElements_10 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_9 = this.compileAnnotationProperty(af_5, im);
                _builder.append(_compileAnnotationProperty_9, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setInit(String... associations) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (associations == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String association : associations)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initAssociations.add(association);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_6 = aaf.getAttributeAnnotations();
      for(final Annotation a_10 : _attributeAnnotations_6) {
        _builder.append("@");
        JvmType _type_10 = a_10.getType();
        CharSequence _serialize_10 = im.serialize(_type_10);
        _builder.append(_serialize_10, "");
        {
          EList<AnnotationProperty> _features_20 = a_10.getFeatures();
          boolean _isEmpty_10 = _features_20.isEmpty();
          boolean _not_10 = (!_isEmpty_10);
          if (_not_10) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_21 = a_10.getFeatures();
              boolean _hasElements_11 = false;
              for(final AnnotationProperty af_6 : _features_21) {
                if (!_hasElements_11) {
                  _hasElements_11 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_10 = this.compileAnnotationProperty(af_6, im);
                _builder.append(_compileAnnotationProperty_10, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append(" _setInit(String... associations) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setInit(associations);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_7 = aaf.getAttributeAnnotations();
      for(final Annotation a_11 : _attributeAnnotations_7) {
        _builder.append("@");
        JvmType _type_11 = a_11.getType();
        CharSequence _serialize_11 = im.serialize(_type_11);
        _builder.append(_serialize_11, "");
        {
          EList<AnnotationProperty> _features_22 = a_11.getFeatures();
          boolean _isEmpty_11 = _features_22.isEmpty();
          boolean _not_11 = (!_isEmpty_11);
          if (_not_11) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_23 = a_11.getFeatures();
              boolean _hasElements_12 = false;
              for(final AnnotationProperty af_7 : _features_23) {
                if (!_hasElements_12) {
                  _hasElements_12 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_11 = this.compileAnnotationProperty(af_7, im);
                _builder.append(_compileAnnotationProperty_11, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearInit(String... associations) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (associations == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String association : associations)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("initAssociations.remove(association);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_8 = aaf.getAttributeAnnotations();
      for(final Annotation a_12 : _attributeAnnotations_8) {
        _builder.append("@");
        JvmType _type_12 = a_12.getType();
        CharSequence _serialize_12 = im.serialize(_type_12);
        _builder.append(_serialize_12, "");
        {
          EList<AnnotationProperty> _features_24 = a_12.getFeatures();
          boolean _isEmpty_12 = _features_24.isEmpty();
          boolean _not_12 = (!_isEmpty_12);
          if (_not_12) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_25 = a_12.getFeatures();
              boolean _hasElements_13 = false;
              for(final AnnotationProperty af_8 : _features_25) {
                if (!_hasElements_13) {
                  _hasElements_13 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_12 = this.compileAnnotationProperty(af_8, im);
                _builder.append(_compileAnnotationProperty_12, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" _clearInit(String... associations) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearInit(associations);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_9 = aaf.getAttributeAnnotations();
      for(final Annotation a_13 : _attributeAnnotations_9) {
        _builder.append("@");
        JvmType _type_13 = a_13.getType();
        CharSequence _serialize_13 = im.serialize(_type_13);
        _builder.append(_serialize_13, "");
        {
          EList<AnnotationProperty> _features_26 = a_13.getFeatures();
          boolean _isEmpty_13 = _features_26.isEmpty();
          boolean _not_13 = (!_isEmpty_13);
          if (_not_13) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_27 = a_13.getFeatures();
              boolean _hasElements_14 = false;
              for(final AnnotationProperty af_9 : _features_27) {
                if (!_hasElements_14) {
                  _hasElements_14 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_13 = this.compileAnnotationProperty(af_9, im);
                _builder.append(_compileAnnotationProperty_13, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public Boolean toInit(String association) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (association == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return initAssociations.contains(association);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _attributeAnnotations_10 = aaf.getAttributeAnnotations();
      for(final Annotation a_14 : _attributeAnnotations_10) {
        _builder.append("@");
        JvmType _type_14 = a_14.getType();
        CharSequence _serialize_14 = im.serialize(_type_14);
        _builder.append(_serialize_14, "");
        {
          EList<AnnotationProperty> _features_28 = a_14.getFeatures();
          boolean _isEmpty_14 = _features_28.isEmpty();
          boolean _not_14 = (!_isEmpty_14);
          if (_not_14) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_29 = a_14.getFeatures();
              boolean _hasElements_15 = false;
              for(final AnnotationProperty af_10 : _features_29) {
                if (!_hasElements_15) {
                  _hasElements_15 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_14 = this.compileAnnotationProperty(af_10, im);
                _builder.append(_compileAnnotationProperty_14, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearAllInit() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("initAssociations = new HashSet<String>();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileEnumInit(final PojoProperty f, final PojoAnnotatedProperty aaf, final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public enum Association {");
    _builder.newLine();
    _builder.append("  ");
    {
      EList<PojoProperty> _attrs = f.getAttrs();
      boolean _hasElements = false;
      for(final PojoProperty f2 : _attrs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name = f2.getName();
        _builder.append(_name, "  ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileOperators(final ImportManager im, final PojoEntity e, final AnnotatedEntity ae) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public enum OpAttribute {");
    _builder.newLine();
    _builder.append("    ");
    {
      EList<PojoAnnotatedProperty> _features = e.getFeatures();
      final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
          public Boolean apply(final PojoAnnotatedProperty x) {
            PojoProperty _feature = x.getFeature();
            boolean _isAttribute = ProcessorDslGenerator.this.isAttribute(_feature);
            return Boolean.valueOf(_isAttribute);
          }
        };
      Iterable<PojoAnnotatedProperty> _filter = IterableExtensions.<PojoAnnotatedProperty>filter(_features, _function);
      boolean _hasElements = false;
      for(final PojoAnnotatedProperty f : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "    ");
        }
        PojoProperty _feature = f.getFeature();
        String _name = _feature.getName();
        _builder.append(_name, "    ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations = ae.getConflictAnnotations();
      for(final Annotation a : _conflictAnnotations) {
        _builder.append("@");
        JvmType _type = a.getType();
        CharSequence _serialize = im.serialize(_type);
        _builder.append(_serialize, "");
        {
          EList<AnnotationProperty> _features_1 = a.getFeatures();
          boolean _isEmpty = _features_1.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_2 = a.getFeatures();
              boolean _hasElements_1 = false;
              for(final AnnotationProperty ff : _features_2) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty = this.compileAnnotationProperty(ff, im);
                _builder.append(_compileAnnotationProperty, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("private Map<String, String> operators = new HashMap<String, String>();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public Map<String, String> getOperators() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return operators;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_1 = ae.getConflictAnnotations();
      for(final Annotation a_1 : _conflictAnnotations_1) {
        _builder.append("@");
        JvmType _type_1 = a_1.getType();
        CharSequence _serialize_1 = im.serialize(_type_1);
        _builder.append(_serialize_1, "");
        {
          EList<AnnotationProperty> _features_3 = a_1.getFeatures();
          boolean _isEmpty_1 = _features_3.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_4 = a_1.getFeatures();
              boolean _hasElements_2 = false;
              for(final AnnotationProperty ff_1 : _features_4) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_1 = this.compileAnnotationProperty(ff_1, im);
                _builder.append(_compileAnnotationProperty_1, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setOp(String operator, OpAttribute... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (OpAttribute attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.put(attribute.name(), operator);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_2 = ae.getConflictAnnotations();
      for(final Annotation a_2 : _conflictAnnotations_2) {
        _builder.append("@");
        JvmType _type_2 = a_2.getType();
        CharSequence _serialize_2 = im.serialize(_type_2);
        _builder.append(_serialize_2, "");
        {
          EList<AnnotationProperty> _features_5 = a_2.getFeatures();
          boolean _isEmpty_2 = _features_5.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_6 = a_2.getFeatures();
              boolean _hasElements_3 = false;
              for(final AnnotationProperty ff_2 : _features_6) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_2 = this.compileAnnotationProperty(ff_2, im);
                _builder.append(_compileAnnotationProperty_2, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" _setOp(String operator, OpAttribute... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setOp(operator, attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_3 = ae.getConflictAnnotations();
      for(final Annotation a_3 : _conflictAnnotations_3) {
        _builder.append("@");
        JvmType _type_3 = a_3.getType();
        CharSequence _serialize_3 = im.serialize(_type_3);
        _builder.append(_serialize_3, "");
        {
          EList<AnnotationProperty> _features_7 = a_3.getFeatures();
          boolean _isEmpty_3 = _features_7.isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          if (_not_3) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_8 = a_3.getFeatures();
              boolean _hasElements_4 = false;
              for(final AnnotationProperty ff_3 : _features_8) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_3 = this.compileAnnotationProperty(ff_3, im);
                _builder.append(_compileAnnotationProperty_3, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void clearOp(OpAttribute... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (OpAttribute attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.remove(attribute.name());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_4 = ae.getConflictAnnotations();
      for(final Annotation a_4 : _conflictAnnotations_4) {
        _builder.append("@");
        JvmType _type_4 = a_4.getType();
        CharSequence _serialize_4 = im.serialize(_type_4);
        _builder.append(_serialize_4, "");
        {
          EList<AnnotationProperty> _features_9 = a_4.getFeatures();
          boolean _isEmpty_4 = _features_9.isEmpty();
          boolean _not_4 = (!_isEmpty_4);
          if (_not_4) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_10 = a_4.getFeatures();
              boolean _hasElements_5 = false;
              for(final AnnotationProperty ff_4 : _features_10) {
                if (!_hasElements_5) {
                  _hasElements_5 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_4 = this.compileAnnotationProperty(ff_4, im);
                _builder.append(_compileAnnotationProperty_4, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" _clearOp(OpAttribute... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearOp(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void setOp(String operator, String... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.put(attribute, operator);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append(" _setOp(String operator, String... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setOp(operator, attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void clearOp(String... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.remove(attribute);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" _clearOp(String... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("clearOp(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_5 = ae.getConflictAnnotations();
      for(final Annotation a_5 : _conflictAnnotations_5) {
        _builder.append("@");
        JvmType _type_5 = a_5.getType();
        CharSequence _serialize_5 = im.serialize(_type_5);
        _builder.append(_serialize_5, "");
        {
          EList<AnnotationProperty> _features_11 = a_5.getFeatures();
          boolean _isEmpty_5 = _features_11.isEmpty();
          boolean _not_5 = (!_isEmpty_5);
          if (_not_5) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_12 = a_5.getFeatures();
              boolean _hasElements_6 = false;
              for(final AnnotationProperty ff_5 : _features_12) {
                if (!_hasElements_6) {
                  _hasElements_6 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_5 = this.compileAnnotationProperty(ff_5, im);
                _builder.append(_compileAnnotationProperty_5, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public void setNullOp(OpAttribute... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (OpAttribute attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.put(attribute.name(), \"is null\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Annotation> _conflictAnnotations_6 = ae.getConflictAnnotations();
      for(final Annotation a_6 : _conflictAnnotations_6) {
        _builder.append("@");
        JvmType _type_6 = a_6.getType();
        CharSequence _serialize_6 = im.serialize(_type_6);
        _builder.append(_serialize_6, "");
        {
          EList<AnnotationProperty> _features_13 = a_6.getFeatures();
          boolean _isEmpty_6 = _features_13.isEmpty();
          boolean _not_6 = (!_isEmpty_6);
          if (_not_6) {
            _builder.append("(");
            {
              EList<AnnotationProperty> _features_14 = a_6.getFeatures();
              boolean _hasElements_7 = false;
              for(final AnnotationProperty ff_6 : _features_14) {
                if (!_hasElements_7) {
                  _hasElements_7 = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                CharSequence _compileAnnotationProperty_6 = this.compileAnnotationProperty(ff_6, im);
                _builder.append(_compileAnnotationProperty_6, "");
              }
            }
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    String _name_5 = e.getName();
    _builder.append(_name_5, "");
    _builder.append(" _setNullOp(OpAttribute... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setNullOp(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void setNullOp(String... attributes) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (attributes == null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new IllegalArgumentException();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (String attribute : attributes)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("operators.put(attribute, \"is null\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" _setNullOp(String... attributes) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("setNullOp(attributes);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void clearAllOps() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("operators = new HashMap<String, String>();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileType(final EnumProperty f, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _native = f.getNative();
      boolean _notEquals = (!Objects.equal(_native, null));
      if (_notEquals) {
        String _native_1 = f.getNative();
        String _substring = _native_1.substring(1);
        _builder.append(_substring, "");
      } else {
        JvmType _type = f.getType();
        boolean _notEquals_1 = (!Objects.equal(_type, null));
        if (_notEquals_1) {
          JvmType _type_1 = f.getType();
          CharSequence _serialize = im.serialize(_type_1);
          _builder.append(_serialize, "");
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileType(final PojoProperty f, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _native = f.getNative();
      boolean _notEquals = (!Objects.equal(_native, null));
      if (_notEquals) {
        String _native_1 = f.getNative();
        String _substring = _native_1.substring(1);
        _builder.append(_substring, "");
      } else {
        Entity _ref = f.getRef();
        boolean _notEquals_1 = (!Objects.equal(_ref, null));
        if (_notEquals_1) {
          Entity _ref_1 = f.getRef();
          QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_ref_1);
          _builder.append(_fullyQualifiedName, "");
        } else {
          JvmType _type = f.getType();
          boolean _notEquals_2 = (!Objects.equal(_type, null));
          if (_notEquals_2) {
            JvmType _type_1 = f.getType();
            CharSequence _serialize = im.serialize(_type_1);
            _builder.append(_serialize, "");
          }
        }
      }
    }
    {
      JvmType _gtype = f.getGtype();
      boolean _notEquals_3 = (!Objects.equal(_gtype, null));
      if (_notEquals_3) {
        _builder.append("<");
        JvmType _gtype_1 = f.getGtype();
        CharSequence _serialize_1 = im.serialize(_gtype_1);
        _builder.append(_serialize_1, "");
        _builder.append(">");
      }
    }
    {
      PojoEntity _gref = f.getGref();
      boolean _notEquals_4 = (!Objects.equal(_gref, null));
      if (_notEquals_4) {
        _builder.append("<");
        PojoEntity _gref_1 = f.getGref();
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(_gref_1);
        _builder.append(_fullyQualifiedName_1, "");
        _builder.append(">");
      }
    }
    {
      boolean _isArray = f.isArray();
      if (_isArray) {
        _builder.append("[]");
      }
    }
    return _builder;
  }
  
  public CharSequence compileType(final PojoType f, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _native = f.getNative();
      boolean _notEquals = (!Objects.equal(_native, null));
      if (_notEquals) {
        String _native_1 = f.getNative();
        String _substring = _native_1.substring(1);
        _builder.append(_substring, "");
      } else {
        PojoEntity _ref = f.getRef();
        boolean _notEquals_1 = (!Objects.equal(_ref, null));
        if (_notEquals_1) {
          PojoEntity _ref_1 = f.getRef();
          JvmType _pojoMethod2jvmType = Utils.pojoMethod2jvmType(_ref_1);
          CharSequence _serialize = im.serialize(_pojoMethod2jvmType);
          _builder.append(_serialize, "");
        } else {
          JvmType _type = f.getType();
          boolean _notEquals_2 = (!Objects.equal(_type, null));
          if (_notEquals_2) {
            JvmType _type_1 = f.getType();
            CharSequence _serialize_1 = im.serialize(_type_1);
            _builder.append(_serialize_1, "");
          }
        }
      }
    }
    {
      JvmType _gtype = f.getGtype();
      boolean _notEquals_3 = (!Objects.equal(_gtype, null));
      if (_notEquals_3) {
        _builder.append("<");
        JvmType _gtype_1 = f.getGtype();
        CharSequence _serialize_2 = im.serialize(_gtype_1);
        _builder.append(_serialize_2, "");
        _builder.append(">");
      }
    }
    {
      PojoEntity _gref = f.getGref();
      boolean _notEquals_4 = (!Objects.equal(_gref, null));
      if (_notEquals_4) {
        _builder.append("<");
        PojoEntity _gref_1 = f.getGref();
        JvmType _pojoMethod2jvmType_1 = Utils.pojoMethod2jvmType(_gref_1);
        CharSequence _serialize_3 = im.serialize(_pojoMethod2jvmType_1);
        _builder.append(_serialize_3, "");
        _builder.append(">");
      }
    }
    {
      boolean _isArray = f.isArray();
      if (_isArray) {
        _builder.append("[]");
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final PojoDao d) {
    StringConcatenation _builder = new StringConcatenation();
    ImportManager _importManager = new ImportManager(true);
    final ImportManager im = _importManager;
    _builder.newLineIfNotEmpty();
    this.addImplements(d, im);
    _builder.newLineIfNotEmpty();
    this.addExtends(d, im);
    _builder.newLineIfNotEmpty();
    final Map<String,List<PojoMethodArg>> toInits = Utils.getToInits(d);
    _builder.newLineIfNotEmpty();
    PojoEntity _pojo = d.getPojo();
    final CharSequence classBody = this.compile(d, _pojo, toInits, im);
    _builder.newLineIfNotEmpty();
    {
      EObject _eContainer = d.eContainer();
      boolean _notEquals = (!Objects.equal(_eContainer, null));
      if (_notEquals) {
        _builder.append("package ");
        EObject _eContainer_1 = d.eContainer();
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_1);
        _builder.append(_fullyQualifiedName, "");
        {
          String _implPackage = this.getImplPackage(d);
          boolean _notEquals_1 = (!Objects.equal(_implPackage, null));
          if (_notEquals_1) {
            _builder.append(".");
            String _implPackage_1 = this.getImplPackage(d);
            _builder.append(_implPackage_1, "");
          }
        }
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      String _implPackage_2 = this.getImplPackage(d);
      boolean _notEquals_2 = (!Objects.equal(_implPackage_2, null));
      if (_notEquals_2) {
        _builder.newLine();
        _builder.append("import ");
        EObject _eContainer_2 = d.eContainer();
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_2);
        _builder.append(_fullyQualifiedName_1, "");
        _builder.append(".");
        String _name = d.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<String> _imports = im.getImports();
      boolean _isEmpty = _imports.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("  ");
        _builder.newLine();
        {
          List<String> _imports_1 = im.getImports();
          for(final String i : _imports_1) {
            _builder.append("import ");
            _builder.append(i, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      String _sernum = Utils.getSernum(d);
      boolean _notEquals_3 = (!Objects.equal(_sernum, null));
      if (_notEquals_3) {
        _builder.newLine();
        _builder.append("import java.io.Serializable;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlControl;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlCrudEngine;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlEngineFactory;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlQueryEngine;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlProcedureEngine;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlSession;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlSessionFactory;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.impl.SqlStandardControl;");
    _builder.newLine();
    {
      PojoEntity _pojo_1 = d.getPojo();
      boolean _notEquals_4 = (!Objects.equal(_pojo_1, null));
      if (_notEquals_4) {
        _builder.append("import ");
        PojoEntity _pojo_2 = d.getPojo();
        String _completeName = this.completeName(_pojo_2);
        _builder.append(_completeName, "");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Set<Entry<String,List<PojoMethodArg>>> _entrySet = toInits.entrySet();
      for(final Entry<String,List<PojoMethodArg>> f : _entrySet) {
        {
          List<PojoMethodArg> _value = f.getValue();
          boolean _hasElements = false;
          for(final PojoMethodArg a : _value) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.append("import ");
            PojoType _type = a.getType();
            PojoEntity _ref = _type.getRef();
            String _completeName_1 = this.completeName(_ref);
            _builder.append(_completeName_1, "");
            _builder.append(";");
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(classBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compile(final PojoDao d, final PojoEntity e, final Map<String,List<PojoMethodArg>> toInits, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    {
      boolean _isAbstract = Utils.isAbstract(d);
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    _builder.append("class ");
    String _name = d.getName();
    _builder.append(_name, "");
    {
      String _implPackage = this.getImplPackage(d);
      boolean _notEquals = (!Objects.equal(_implPackage, null));
      if (_notEquals) {
        _builder.append("Impl");
      }
    }
    _builder.append(" ");
    CharSequence _compileExtends = this.compileExtends(d, im);
    _builder.append(_compileExtends, "");
    CharSequence _compileImplements = this.compileImplements(d);
    _builder.append(_compileImplements, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      String _sernum = Utils.getSernum(d);
      boolean _notEquals_1 = (!Objects.equal(_sernum, null));
      if (_notEquals_1) {
        _builder.append("  ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("private static final long serialVersionUID = ");
        String _sernum_1 = Utils.getSernum(d);
        _builder.append(_sernum_1, "  ");
        _builder.append("L;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("protected final Logger logger = LoggerFactory.getLogger(getClass());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected SqlEngineFactory sqlEngineFactory;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("protected SqlSessionFactory sqlSessionFactory;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public ");
    String _name_1 = d.getName();
    _builder.append(_name_1, "  ");
    {
      String _implPackage_1 = this.getImplPackage(d);
      boolean _notEquals_2 = (!Objects.equal(_implPackage_1, null));
      if (_notEquals_2) {
        _builder.append("Impl");
      }
    }
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public ");
    String _name_2 = d.getName();
    _builder.append(_name_2, "  ");
    {
      String _implPackage_2 = this.getImplPackage(d);
      boolean _notEquals_3 = (!Objects.equal(_implPackage_2, null));
      if (_notEquals_3) {
        _builder.append("Impl");
      }
    }
    _builder.append("(SqlEngineFactory sqlEngineFactory) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("this.sqlEngineFactory = sqlEngineFactory;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public ");
    String _name_3 = d.getName();
    _builder.append(_name_3, "  ");
    {
      String _implPackage_3 = this.getImplPackage(d);
      boolean _notEquals_4 = (!Objects.equal(_implPackage_3, null));
      if (_notEquals_4) {
        _builder.append("Impl");
      }
    }
    _builder.append("(SqlEngineFactory sqlEngineFactory, SqlSessionFactory sqlSessionFactory) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("this.sqlEngineFactory = sqlEngineFactory;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.sqlSessionFactory = sqlSessionFactory;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    {
      EList<PojoMethod> _methods = d.getMethods();
      for(final PojoMethod m : _methods) {
        {
          String _name_4 = m.getName();
          boolean _equals = Objects.equal(_name_4, "scaffold");
          if (_equals) {
            PojoEntity _parent = Utils.getParent(e);
            CharSequence _compileInsert = this.compileInsert(d, e, _parent, im);
            _builder.append(_compileInsert, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileGet = this.compileGet(d, e, toInits, im);
            _builder.append(_compileGet, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            PojoEntity _parent_1 = Utils.getParent(e);
            CharSequence _compileUpdate = this.compileUpdate(d, e, _parent_1, im);
            _builder.append(_compileUpdate, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            PojoEntity _parent_2 = Utils.getParent(e);
            CharSequence _compileDelete = this.compileDelete(d, e, _parent_2, im);
            _builder.append(_compileDelete, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileList = this.compileList(d, e, toInits, im);
            _builder.append(_compileList, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileCount = this.compileCount(d, e, toInits, im);
            _builder.append(_compileCount, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            {
              boolean _isEmpty = toInits.isEmpty();
              boolean _not = (!_isEmpty);
              if (_not) {
                CharSequence _compileMoreResultClasses = this.compileMoreResultClasses(d, e, toInits, im);
                _builder.append(_compileMoreResultClasses, "  ");
              }
            }
          } else {
            boolean _isCallUpdate = Utils.isCallUpdate(m);
            if (_isCallUpdate) {
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
              CharSequence _compileCallUpdate = this.compileCallUpdate(d, m, im);
              _builder.append(_compileCallUpdate, "  ");
            } else {
              boolean _isCallFunction = Utils.isCallFunction(m);
              if (_isCallFunction) {
                CharSequence _compileCallFunction = this.compileCallFunction(d, m, im);
                _builder.append(_compileCallFunction, "  ");
              } else {
                boolean _or = false;
                boolean _isCallQuery = Utils.isCallQuery(m);
                if (_isCallQuery) {
                  _or = true;
                } else {
                  boolean _isCallQueryFunction = Utils.isCallQueryFunction(m);
                  _or = (_isCallQuery || _isCallQueryFunction);
                }
                if (_or) {
                  boolean _isCallQueryFunction_1 = Utils.isCallQueryFunction(m);
                  CharSequence _compileCallQuery = this.compileCallQuery(d, m, im, _isCallQueryFunction_1);
                  _builder.append(_compileCallQuery, "  ");
                } else {
                  boolean _isCallSelectFunction = Utils.isCallSelectFunction(m);
                  if (_isCallSelectFunction) {
                    CharSequence _compileCallSelectFunction = this.compileCallSelectFunction(d, m, im);
                    _builder.append(_compileCallSelectFunction, "  ");
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCallQuery(final PojoDao d, final PojoMethod m, final ImportManager im, final boolean isFunction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_2 = m.getName();
    _builder.append(_name_2, "    ");
    _builder.append(": \" + ");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" + \" \" ", "    ");
        }
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "    ");
      }
    }
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlProcedureEngine sqlProc");
    String _name_4 = m.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedProcedureEngine(\"");
    {
      if (isFunction) {
        _builder.append("FUN");
      } else {
        _builder.append("PROC");
      }
    }
    _builder.append("_");
    String _dbName = Utils.dbName(m);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    PojoType _type_2 = m.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "  ");
    _builder.append(" list = sqlProc");
    String _name_5 = m.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_1, "  ");
    _builder.append(".callQuery(sqlSession, ");
    PojoType _type_3 = m.getType();
    PojoEntity _gref = _type_3.getGref();
    String _name_6 = _gref.getName();
    _builder.append(_name_6, "  ");
    _builder.append(".class, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_7 = ma_2.getName();
        _builder.append(_name_7, "  ");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_8 = m.getName();
    _builder.append(_name_8, "    ");
    _builder.append(" result: \" + list);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return list;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_4 = m.getType();
    CharSequence _compileType_3 = this.compileType(_type_4, im);
    _builder.append(_compileType_3, "");
    _builder.append(" ");
    String _name_9 = m.getName();
    _builder.append(_name_9, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_5 = ma_3.getType();
        CharSequence _compileType_4 = this.compileType(_type_5, im);
        _builder.append(_compileType_4, "");
        _builder.append(" ");
        String _name_10 = ma_3.getName();
        _builder.append(_name_10, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_11 = m.getName();
    _builder.append(_name_11, "	");
    _builder.append("(sqlSessionFactory.getSqlSession(), ");
    {
      EList<PojoMethodArg> _args_4 = m.getArgs();
      boolean _hasElements_4 = false;
      for(final PojoMethodArg ma_4 : _args_4) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(", ", "	");
        }
        String _name_12 = ma_4.getName();
        _builder.append(_name_12, "	");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_6 = m.getType();
    CharSequence _compileType_5 = this.compileType(_type_6, im);
    _builder.append(_compileType_5, "");
    _builder.append(" ");
    String _name_13 = m.getName();
    _builder.append(_name_13, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_5 = m.getArgs();
      boolean _hasElements_5 = false;
      for(final PojoMethodArg ma_5 : _args_5) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_7 = ma_5.getType();
        CharSequence _compileType_6 = this.compileType(_type_7, im);
        _builder.append(_compileType_6, "");
        _builder.append(" ");
        String _name_14 = ma_5.getName();
        _builder.append(_name_14, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_15 = m.getName();
    _builder.append(_name_15, "  ");
    _builder.append("(sqlSession, ");
    {
      EList<PojoMethodArg> _args_6 = m.getArgs();
      boolean _hasElements_6 = false;
      for(final PojoMethodArg ma_6 : _args_6) {
        if (!_hasElements_6) {
          _hasElements_6 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_16 = ma_6.getName();
        _builder.append(_name_16, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_8 = m.getType();
    CharSequence _compileType_7 = this.compileType(_type_8, im);
    _builder.append(_compileType_7, "");
    _builder.append(" ");
    String _name_17 = m.getName();
    _builder.append(_name_17, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_7 = m.getArgs();
      boolean _hasElements_7 = false;
      for(final PojoMethodArg ma_7 : _args_7) {
        if (!_hasElements_7) {
          _hasElements_7 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_9 = ma_7.getType();
        CharSequence _compileType_8 = this.compileType(_type_9, im);
        _builder.append(_compileType_8, "");
        _builder.append(" ");
        String _name_18 = ma_7.getName();
        _builder.append(_name_18, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_19 = m.getName();
    _builder.append(_name_19, "  ");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_8 = m.getArgs();
      boolean _hasElements_8 = false;
      for(final PojoMethodArg ma_8 : _args_8) {
        if (!_hasElements_8) {
          _hasElements_8 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_20 = ma_8.getName();
        _builder.append(_name_20, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCallFunction(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_2 = m.getName();
    _builder.append(_name_2, "    ");
    _builder.append(": \" + ");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" + \" \" ", "    ");
        }
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "    ");
      }
    }
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlProcedureEngine sqlFun");
    String _name_4 = m.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedProcedureEngine(\"FUN_");
    String _dbName = Utils.dbName(m);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("Object result = sqlFun");
    String _name_5 = m.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_1, "  ");
    _builder.append(".callFunction(sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_6 = ma_2.getName();
        _builder.append(_name_6, "  ");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_7 = m.getName();
    _builder.append(_name_7, "    ");
    _builder.append(" result: \" + result);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return (");
    PojoType _type_2 = m.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "  ");
    _builder.append(") result;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_3 = m.getType();
    CharSequence _compileType_3 = this.compileType(_type_3, im);
    _builder.append(_compileType_3, "");
    _builder.append(" ");
    String _name_8 = m.getName();
    _builder.append(_name_8, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_4 = ma_3.getType();
        CharSequence _compileType_4 = this.compileType(_type_4, im);
        _builder.append(_compileType_4, "");
        _builder.append(" ");
        String _name_9 = ma_3.getName();
        _builder.append(_name_9, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_10 = m.getName();
    _builder.append(_name_10, "	");
    _builder.append("(sqlSessionFactory.getSqlSession(), ");
    {
      EList<PojoMethodArg> _args_4 = m.getArgs();
      boolean _hasElements_4 = false;
      for(final PojoMethodArg ma_4 : _args_4) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(", ", "	");
        }
        String _name_11 = ma_4.getName();
        _builder.append(_name_11, "	");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_5 = m.getType();
    CharSequence _compileType_5 = this.compileType(_type_5, im);
    _builder.append(_compileType_5, "");
    _builder.append(" ");
    String _name_12 = m.getName();
    _builder.append(_name_12, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_5 = m.getArgs();
      boolean _hasElements_5 = false;
      for(final PojoMethodArg ma_5 : _args_5) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_6 = ma_5.getType();
        CharSequence _compileType_6 = this.compileType(_type_6, im);
        _builder.append(_compileType_6, "");
        _builder.append(" ");
        String _name_13 = ma_5.getName();
        _builder.append(_name_13, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_14 = m.getName();
    _builder.append(_name_14, "  ");
    _builder.append("(sqlSession, ");
    {
      EList<PojoMethodArg> _args_6 = m.getArgs();
      boolean _hasElements_6 = false;
      for(final PojoMethodArg ma_6 : _args_6) {
        if (!_hasElements_6) {
          _hasElements_6 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_15 = ma_6.getName();
        _builder.append(_name_15, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_7 = m.getType();
    CharSequence _compileType_7 = this.compileType(_type_7, im);
    _builder.append(_compileType_7, "");
    _builder.append(" ");
    String _name_16 = m.getName();
    _builder.append(_name_16, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_7 = m.getArgs();
      boolean _hasElements_7 = false;
      for(final PojoMethodArg ma_7 : _args_7) {
        if (!_hasElements_7) {
          _hasElements_7 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_8 = ma_7.getType();
        CharSequence _compileType_8 = this.compileType(_type_8, im);
        _builder.append(_compileType_8, "");
        _builder.append(" ");
        String _name_17 = ma_7.getName();
        _builder.append(_name_17, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_18 = m.getName();
    _builder.append(_name_18, "  ");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_8 = m.getArgs();
      boolean _hasElements_8 = false;
      for(final PojoMethodArg ma_8 : _args_8) {
        if (!_hasElements_8) {
          _hasElements_8 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_19 = ma_8.getName();
        _builder.append(_name_19, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCallUpdate(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type = ma.getType();
        CharSequence _compileType = this.compileType(_type, im);
        _builder.append(_compileType, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_2 = m.getName();
    _builder.append(_name_2, "    ");
    _builder.append(": \" + ");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" + \" \" ", "    ");
        }
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "    ");
      }
    }
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlProcedureEngine sqlProc");
    String _name_4 = m.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedProcedureEngine(\"PROC_");
    String _dbName = Utils.dbName(m);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("int count = sqlProc");
    String _name_5 = m.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_1, "  ");
    _builder.append(".callUpdate(sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_6 = ma_2.getName();
        _builder.append(_name_6, "  ");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_7 = m.getName();
    _builder.append(_name_7, "    ");
    _builder.append(" result: \" + count);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return count;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int ");
    String _name_8 = m.getName();
    _builder.append(_name_8, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma_3.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_9 = ma_3.getName();
        _builder.append(_name_9, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_10 = m.getName();
    _builder.append(_name_10, "	");
    _builder.append("(sqlSessionFactory.getSqlSession(), ");
    {
      EList<PojoMethodArg> _args_4 = m.getArgs();
      boolean _hasElements_4 = false;
      for(final PojoMethodArg ma_4 : _args_4) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(", ", "	");
        }
        String _name_11 = ma_4.getName();
        _builder.append(_name_11, "	");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int ");
    String _name_12 = m.getName();
    _builder.append(_name_12, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_5 = m.getArgs();
      boolean _hasElements_5 = false;
      for(final PojoMethodArg ma_5 : _args_5) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_2 = ma_5.getType();
        CharSequence _compileType_2 = this.compileType(_type_2, im);
        _builder.append(_compileType_2, "");
        _builder.append(" ");
        String _name_13 = ma_5.getName();
        _builder.append(_name_13, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_14 = m.getName();
    _builder.append(_name_14, "  ");
    _builder.append("(sqlSession, ");
    {
      EList<PojoMethodArg> _args_6 = m.getArgs();
      boolean _hasElements_6 = false;
      for(final PojoMethodArg ma_6 : _args_6) {
        if (!_hasElements_6) {
          _hasElements_6 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_15 = ma_6.getName();
        _builder.append(_name_15, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int ");
    String _name_16 = m.getName();
    _builder.append(_name_16, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_7 = m.getArgs();
      boolean _hasElements_7 = false;
      for(final PojoMethodArg ma_7 : _args_7) {
        if (!_hasElements_7) {
          _hasElements_7 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_3 = ma_7.getType();
        CharSequence _compileType_3 = this.compileType(_type_3, im);
        _builder.append(_compileType_3, "");
        _builder.append(" ");
        String _name_17 = ma_7.getName();
        _builder.append(_name_17, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_18 = m.getName();
    _builder.append(_name_18, "  ");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_8 = m.getArgs();
      boolean _hasElements_8 = false;
      for(final PojoMethodArg ma_8 : _args_8) {
        if (!_hasElements_8) {
          _hasElements_8 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_19 = ma_8.getName();
        _builder.append(_name_19, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCallSelectFunction(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_2 = m.getName();
    _builder.append(_name_2, "    ");
    _builder.append(": \" + ");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(" + \" \" ", "    ");
        }
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "    ");
      }
    }
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlQueryEngine sqlFun");
    String _name_4 = m.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedQueryEngine(\"FUN_");
    String _dbName = Utils.dbName(m);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("java.util.List<");
    EList<PojoMethodArg> _args_2 = m.getArgs();
    PojoMethodArg _get = _args_2.get(0);
    PojoType _type_2 = _get.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "  ");
    _builder.append("> list = sqlFun");
    String _name_5 = m.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_1, "  ");
    _builder.append(".query(sqlSession, ");
    EList<PojoMethodArg> _args_3 = m.getArgs();
    PojoMethodArg _get_1 = _args_3.get(0);
    PojoType _type_3 = _get_1.getType();
    CharSequence _compileType_3 = this.compileType(_type_3, im);
    _builder.append(_compileType_3, "  ");
    _builder.append(".class, ");
    {
      EList<PojoMethodArg> _args_4 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_4) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_6 = ma_2.getName();
        _builder.append(_name_6, "  ");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"");
    String _name_7 = m.getName();
    _builder.append(_name_7, "    ");
    _builder.append(" result: \" + list);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return (list != null && !list.isEmpty()) ? list.get(0).getResult() : null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_4 = m.getType();
    CharSequence _compileType_4 = this.compileType(_type_4, im);
    _builder.append(_compileType_4, "");
    _builder.append(" ");
    String _name_8 = m.getName();
    _builder.append(_name_8, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_5 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_5) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_5 = ma_3.getType();
        CharSequence _compileType_5 = this.compileType(_type_5, im);
        _builder.append(_compileType_5, "");
        _builder.append(" ");
        String _name_9 = ma_3.getName();
        _builder.append(_name_9, "");
      }
    }
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_10 = m.getName();
    _builder.append(_name_10, "	");
    _builder.append("(sqlSessionFactory.getSqlSession(), ");
    {
      EList<PojoMethodArg> _args_6 = m.getArgs();
      boolean _hasElements_4 = false;
      for(final PojoMethodArg ma_4 : _args_6) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(", ", "	");
        }
        String _name_11 = ma_4.getName();
        _builder.append(_name_11, "	");
      }
    }
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_6 = m.getType();
    CharSequence _compileType_6 = this.compileType(_type_6, im);
    _builder.append(_compileType_6, "");
    _builder.append(" ");
    String _name_12 = m.getName();
    _builder.append(_name_12, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_7 = m.getArgs();
      boolean _hasElements_5 = false;
      for(final PojoMethodArg ma_5 : _args_7) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_7 = ma_5.getType();
        CharSequence _compileType_7 = this.compileType(_type_7, im);
        _builder.append(_compileType_7, "");
        _builder.append(" ");
        String _name_13 = ma_5.getName();
        _builder.append(_name_13, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_14 = m.getName();
    _builder.append(_name_14, "  ");
    _builder.append("(sqlSession, ");
    {
      EList<PojoMethodArg> _args_8 = m.getArgs();
      boolean _hasElements_6 = false;
      for(final PojoMethodArg ma_6 : _args_8) {
        if (!_hasElements_6) {
          _hasElements_6 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_15 = ma_6.getName();
        _builder.append(_name_15, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_8 = m.getType();
    CharSequence _compileType_8 = this.compileType(_type_8, im);
    _builder.append(_compileType_8, "");
    _builder.append(" ");
    String _name_16 = m.getName();
    _builder.append(_name_16, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_9 = m.getArgs();
      boolean _hasElements_7 = false;
      for(final PojoMethodArg ma_7 : _args_9) {
        if (!_hasElements_7) {
          _hasElements_7 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_9 = ma_7.getType();
        CharSequence _compileType_9 = this.compileType(_type_9, im);
        _builder.append(_compileType_9, "");
        _builder.append(" ");
        String _name_17 = ma_7.getName();
        _builder.append(_name_17, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return ");
    String _name_18 = m.getName();
    _builder.append(_name_18, "  ");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_10 = m.getArgs();
      boolean _hasElements_8 = false;
      for(final PojoMethodArg ma_8 : _args_10) {
        if (!_hasElements_8) {
          _hasElements_8 = true;
        } else {
          _builder.appendImmediate(", ", "  ");
        }
        String _name_19 = ma_8.getName();
        _builder.append(_name_19, "  ");
      }
    }
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileInsert(final PojoDao d, final PojoEntity e, final PojoEntity pe, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" insert(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"insert ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "    ");
    _builder.append(": \" + ");
    String _name_4 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_4);
    _builder.append(_firstLower_2, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlCrudEngine sqlInsert");
    String _name_5 = e.getName();
    _builder.append(_name_5, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"INSERT_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    {
      boolean _notEquals = (!Objects.equal(pe, null));
      if (_notEquals) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("SqlCrudEngine sqlInsert");
        String _name_6 = pe.getName();
        _builder.append(_name_6, "  ");
        _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"INSERT_");
        String _dbName_1 = Utils.dbName(pe);
        _builder.append(_dbName_1, "  ");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("int count = sqlInsert");
        String _name_7 = pe.getName();
        _builder.append(_name_7, "  ");
        _builder.append(".insert(sqlSession, ");
        String _name_8 = e.getName();
        String _firstLower_3 = StringExtensions.toFirstLower(_name_8);
        _builder.append(_firstLower_3, "  ");
        _builder.append(", sqlControl);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("if (count > 0) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("sqlInsert");
        String _name_9 = e.getName();
        _builder.append(_name_9, "    ");
        _builder.append(".insert(sqlSession, ");
        String _name_10 = e.getName();
        String _firstLower_4 = StringExtensions.toFirstLower(_name_10);
        _builder.append(_firstLower_4, "    ");
        _builder.append(", sqlControl);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
      } else {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("int count = sqlInsert");
        String _name_11 = e.getName();
        _builder.append(_name_11, "  ");
        _builder.append(".insert(sqlSession, ");
        String _name_12 = e.getName();
        String _firstLower_5 = StringExtensions.toFirstLower(_name_12);
        _builder.append(_firstLower_5, "  ");
        _builder.append(", sqlControl);");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"insert ");
    String _name_13 = e.getName();
    String _firstLower_6 = StringExtensions.toFirstLower(_name_13);
    _builder.append(_firstLower_6, "    ");
    _builder.append(" result: \" + count + \" \" + ");
    String _name_14 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_14);
    _builder.append(_firstLower_7, "    ");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return (count > 0) ? ");
    String _name_15 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_15);
    _builder.append(_firstLower_8, "  ");
    _builder.append(" : null;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_16 = e.getName();
    _builder.append(_name_16, "");
    _builder.append(" insert(");
    String _name_17 = e.getName();
    _builder.append(_name_17, "");
    _builder.append(" ");
    String _name_18 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_18);
    _builder.append(_firstLower_9, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return insert(sqlSessionFactory.getSqlSession(), ");
    String _name_19 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_19);
    _builder.append(_firstLower_10, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_20 = e.getName();
    _builder.append(_name_20, "");
    _builder.append(" insert(SqlSession sqlSession, ");
    String _name_21 = e.getName();
    _builder.append(_name_21, "");
    _builder.append(" ");
    String _name_22 = e.getName();
    String _firstLower_11 = StringExtensions.toFirstLower(_name_22);
    _builder.append(_firstLower_11, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return insert(sqlSession, ");
    String _name_23 = e.getName();
    String _firstLower_12 = StringExtensions.toFirstLower(_name_23);
    _builder.append(_firstLower_12, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_24 = e.getName();
    _builder.append(_name_24, "");
    _builder.append(" insert(");
    String _name_25 = e.getName();
    _builder.append(_name_25, "");
    _builder.append(" ");
    String _name_26 = e.getName();
    String _firstLower_13 = StringExtensions.toFirstLower(_name_26);
    _builder.append(_firstLower_13, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return insert(");
    String _name_27 = e.getName();
    String _firstLower_14 = StringExtensions.toFirstLower(_name_27);
    _builder.append(_firstLower_14, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileGet(final PojoDao d, final PojoEntity e, final Map<String,List<PojoMethodArg>> toInits, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" get(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"get get: \" + ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlCrudEngine sqlGetEngine");
    String _name_4 = e.getName();
    _builder.append(_name_4, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"GET_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    {
      boolean _isEmpty = toInits.isEmpty();
      if (_isEmpty) {
        _builder.append("//");
      }
    }
    _builder.append("sqlControl = getMoreResultClasses(");
    String _name_5 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_2, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    String _name_6 = e.getName();
    _builder.append(_name_6, "  ");
    _builder.append(" ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "  ");
    _builder.append("Got = sqlGetEngine");
    String _name_8 = e.getName();
    _builder.append(_name_8, "  ");
    _builder.append(".get(sqlSession, ");
    String _name_9 = e.getName();
    _builder.append(_name_9, "  ");
    _builder.append(".class, ");
    String _name_10 = e.getName();
    String _firstLower_4 = StringExtensions.toFirstLower(_name_10);
    _builder.append(_firstLower_4, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"get ");
    String _name_11 = e.getName();
    String _firstLower_5 = StringExtensions.toFirstLower(_name_11);
    _builder.append(_firstLower_5, "    ");
    _builder.append(" result: \" + ");
    String _name_12 = e.getName();
    String _firstLower_6 = StringExtensions.toFirstLower(_name_12);
    _builder.append(_firstLower_6, "    ");
    _builder.append("Got);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return ");
    String _name_13 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_13);
    _builder.append(_firstLower_7, "  ");
    _builder.append("Got;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    String _name_14 = e.getName();
    _builder.append(_name_14, "");
    _builder.append(" get(");
    String _name_15 = e.getName();
    _builder.append(_name_15, "");
    _builder.append(" ");
    String _name_16 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_16);
    _builder.append(_firstLower_8, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return get(sqlSessionFactory.getSqlSession(), ");
    String _name_17 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_17);
    _builder.append(_firstLower_9, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_18 = e.getName();
    _builder.append(_name_18, "");
    _builder.append(" get(SqlSession sqlSession, ");
    String _name_19 = e.getName();
    _builder.append(_name_19, "");
    _builder.append(" ");
    String _name_20 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_20);
    _builder.append(_firstLower_10, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return get(sqlSession, ");
    String _name_21 = e.getName();
    String _firstLower_11 = StringExtensions.toFirstLower(_name_21);
    _builder.append(_firstLower_11, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public ");
    String _name_22 = e.getName();
    _builder.append(_name_22, "");
    _builder.append(" get(");
    String _name_23 = e.getName();
    _builder.append(_name_23, "");
    _builder.append(" ");
    String _name_24 = e.getName();
    String _firstLower_12 = StringExtensions.toFirstLower(_name_24);
    _builder.append(_firstLower_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return get(");
    String _name_25 = e.getName();
    String _firstLower_13 = StringExtensions.toFirstLower(_name_25);
    _builder.append(_firstLower_13, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileUpdate(final PojoDao d, final PojoEntity e, final PojoEntity pe, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int update(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"update ");
    String _name_2 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower_1, "    ");
    _builder.append(": \" + ");
    String _name_3 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_2, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlCrudEngine sqlUpdateEngine");
    String _name_4 = e.getName();
    _builder.append(_name_4, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"UPDATE_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    {
      boolean _notEquals = (!Objects.equal(pe, null));
      if (_notEquals) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("SqlCrudEngine sqlUpdate");
        String _name_5 = pe.getName();
        _builder.append(_name_5, "  ");
        _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"UPDATE_");
        String _dbName_1 = Utils.dbName(pe);
        _builder.append(_dbName_1, "  ");
        _builder.append("\");");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("int count = sqlUpdateEngine");
    String _name_6 = e.getName();
    _builder.append(_name_6, "  ");
    _builder.append(".update(sqlSession, ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "  ");
    _builder.append(", sqlControl);");
    {
      boolean _notEquals_1 = (!Objects.equal(pe, null));
      if (_notEquals_1) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("if (count > 0) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\t");
        _builder.append("sqlUpdate");
        String _name_8 = pe.getName();
        _builder.append(_name_8, "  	");
        _builder.append(".update(sqlSession, ");
        String _name_9 = e.getName();
        String _firstLower_4 = StringExtensions.toFirstLower(_name_9);
        _builder.append(_firstLower_4, "  	");
        _builder.append(", sqlControl);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
      }
    }
    final PojoProperty f = Utils.getOptLock(e);
    {
      boolean _notEquals_2 = (!Objects.equal(f, null));
      if (_notEquals_2) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("if (count > 0) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\t");
        String _name_10 = e.getName();
        String _firstLower_5 = StringExtensions.toFirstLower(_name_10);
        _builder.append(_firstLower_5, "  	");
        _builder.append(".set");
        String _name_11 = f.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_11);
        _builder.append(_firstUpper, "  	");
        _builder.append("(");
        String _name_12 = e.getName();
        String _firstLower_6 = StringExtensions.toFirstLower(_name_12);
        _builder.append(_firstLower_6, "  	");
        _builder.append(".get");
        String _name_13 = f.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_13);
        _builder.append(_firstUpper_1, "  	");
        _builder.append("() + 1);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"update ");
    String _name_14 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_14);
    _builder.append(_firstLower_7, "    ");
    _builder.append(" result count: \" + count);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return count;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int update(");
    String _name_15 = e.getName();
    _builder.append(_name_15, "");
    _builder.append(" ");
    String _name_16 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_16);
    _builder.append(_firstLower_8, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return update(sqlSessionFactory.getSqlSession(), ");
    String _name_17 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_17);
    _builder.append(_firstLower_9, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int update(SqlSession sqlSession, ");
    String _name_18 = e.getName();
    _builder.append(_name_18, "");
    _builder.append(" ");
    String _name_19 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_19);
    _builder.append(_firstLower_10, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return update(sqlSession, ");
    String _name_20 = e.getName();
    String _firstLower_11 = StringExtensions.toFirstLower(_name_20);
    _builder.append(_firstLower_11, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int update(");
    String _name_21 = e.getName();
    _builder.append(_name_21, "");
    _builder.append(" ");
    String _name_22 = e.getName();
    String _firstLower_12 = StringExtensions.toFirstLower(_name_22);
    _builder.append(_firstLower_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return update(");
    String _name_23 = e.getName();
    String _firstLower_13 = StringExtensions.toFirstLower(_name_23);
    _builder.append(_firstLower_13, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileDelete(final PojoDao d, final PojoEntity e, final PojoEntity pe, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int delete(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"delete ");
    String _name_2 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower_1, "    ");
    _builder.append(": \" + ");
    String _name_3 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_2, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlCrudEngine sqlDeleteEngine");
    String _name_4 = e.getName();
    _builder.append(_name_4, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"DELETE_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    {
      boolean _notEquals = (!Objects.equal(pe, null));
      if (_notEquals) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("SqlCrudEngine sqlDelete");
        String _name_5 = pe.getName();
        _builder.append(_name_5, "  ");
        _builder.append(" = sqlEngineFactory.getCheckedCrudEngine(\"DELETE_");
        String _dbName_1 = Utils.dbName(pe);
        _builder.append(_dbName_1, "  ");
        _builder.append("\");");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("int count = sqlDeleteEngine");
    String _name_6 = e.getName();
    _builder.append(_name_6, "  ");
    _builder.append(".delete(sqlSession, ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "  ");
    _builder.append(", sqlControl);");
    {
      boolean _notEquals_1 = (!Objects.equal(pe, null));
      if (_notEquals_1) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("if (count > 0) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\t");
        _builder.append("sqlDelete");
        String _name_8 = pe.getName();
        _builder.append(_name_8, "  	");
        _builder.append(".delete(sqlSession, ");
        String _name_9 = e.getName();
        String _firstLower_4 = StringExtensions.toFirstLower(_name_9);
        _builder.append(_firstLower_4, "  	");
        _builder.append(", sqlControl);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
      }
    }
    final PojoProperty f = Utils.getOptLock(e);
    {
      boolean _notEquals_2 = (!Objects.equal(f, null));
      if (_notEquals_2) {
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("if (count > 0) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\t");
        String _name_10 = e.getName();
        String _firstLower_5 = StringExtensions.toFirstLower(_name_10);
        _builder.append(_firstLower_5, "  	");
        _builder.append(".set");
        String _name_11 = f.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_11);
        _builder.append(_firstUpper, "  	");
        _builder.append("(");
        String _name_12 = e.getName();
        String _firstLower_6 = StringExtensions.toFirstLower(_name_12);
        _builder.append(_firstLower_6, "  	");
        _builder.append(".get");
        String _name_13 = f.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_13);
        _builder.append(_firstUpper_1, "  	");
        _builder.append("() + 1);");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"delete ");
    String _name_14 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_14);
    _builder.append(_firstLower_7, "    ");
    _builder.append(" result count: \" + count);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return count;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int delete(");
    String _name_15 = e.getName();
    _builder.append(_name_15, "");
    _builder.append(" ");
    String _name_16 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_16);
    _builder.append(_firstLower_8, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return delete(sqlSessionFactory.getSqlSession(), ");
    String _name_17 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_17);
    _builder.append(_firstLower_9, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int delete(SqlSession sqlSession, ");
    String _name_18 = e.getName();
    _builder.append(_name_18, "");
    _builder.append(" ");
    String _name_19 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_19);
    _builder.append(_firstLower_10, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return delete(sqlSession, ");
    String _name_20 = e.getName();
    String _firstLower_11 = StringExtensions.toFirstLower(_name_20);
    _builder.append(_firstLower_11, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int delete(");
    String _name_21 = e.getName();
    _builder.append(_name_21, "");
    _builder.append(" ");
    String _name_22 = e.getName();
    String _firstLower_12 = StringExtensions.toFirstLower(_name_22);
    _builder.append(_firstLower_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return delete(");
    String _name_23 = e.getName();
    String _firstLower_13 = StringExtensions.toFirstLower(_name_23);
    _builder.append(_firstLower_13, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileList(final PojoDao d, final PojoEntity e, final Map<String,List<PojoMethodArg>> toInits, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public List<");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append("> list(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"list ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "    ");
    _builder.append(": \" + ");
    String _name_4 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_4);
    _builder.append(_firstLower_2, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlQueryEngine sqlEngine");
    String _name_5 = e.getName();
    _builder.append(_name_5, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedQueryEngine(\"SELECT_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    {
      boolean _isEmpty = toInits.isEmpty();
      if (_isEmpty) {
        _builder.append("//");
      }
    }
    _builder.append("sqlControl = getMoreResultClasses(");
    String _name_6 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_6);
    _builder.append(_firstLower_3, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("List<");
    String _name_7 = e.getName();
    _builder.append(_name_7, "  ");
    _builder.append("> ");
    String _name_8 = e.getName();
    String _firstLower_4 = StringExtensions.toFirstLower(_name_8);
    _builder.append(_firstLower_4, "  ");
    _builder.append("List = sqlEngine");
    String _name_9 = e.getName();
    _builder.append(_name_9, "  ");
    _builder.append(".query(sqlSession, ");
    String _name_10 = e.getName();
    _builder.append(_name_10, "  ");
    _builder.append(".class, ");
    String _name_11 = e.getName();
    String _firstLower_5 = StringExtensions.toFirstLower(_name_11);
    _builder.append(_firstLower_5, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"list ");
    String _name_12 = e.getName();
    String _firstLower_6 = StringExtensions.toFirstLower(_name_12);
    _builder.append(_firstLower_6, "    ");
    _builder.append(" size: \" + ((");
    String _name_13 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_13);
    _builder.append(_firstLower_7, "    ");
    _builder.append("List != null) ? ");
    String _name_14 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_14);
    _builder.append(_firstLower_8, "    ");
    _builder.append("List.size() : \"null\"));");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return ");
    String _name_15 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_15);
    _builder.append(_firstLower_9, "  ");
    _builder.append("List;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public List<");
    String _name_16 = e.getName();
    _builder.append(_name_16, "");
    _builder.append("> list(");
    String _name_17 = e.getName();
    _builder.append(_name_17, "");
    _builder.append(" ");
    String _name_18 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_18);
    _builder.append(_firstLower_10, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return list(sqlSessionFactory.getSqlSession(), ");
    String _name_19 = e.getName();
    String _firstLower_11 = StringExtensions.toFirstLower(_name_19);
    _builder.append(_firstLower_11, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public List<");
    String _name_20 = e.getName();
    _builder.append(_name_20, "");
    _builder.append("> list(SqlSession sqlSession, ");
    String _name_21 = e.getName();
    _builder.append(_name_21, "");
    _builder.append(" ");
    String _name_22 = e.getName();
    String _firstLower_12 = StringExtensions.toFirstLower(_name_22);
    _builder.append(_firstLower_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return list(sqlSession, ");
    String _name_23 = e.getName();
    String _firstLower_13 = StringExtensions.toFirstLower(_name_23);
    _builder.append(_firstLower_13, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public List<");
    String _name_24 = e.getName();
    _builder.append(_name_24, "");
    _builder.append("> list(");
    String _name_25 = e.getName();
    _builder.append(_name_25, "");
    _builder.append(" ");
    String _name_26 = e.getName();
    String _firstLower_14 = StringExtensions.toFirstLower(_name_26);
    _builder.append(_firstLower_14, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return list(");
    String _name_27 = e.getName();
    String _firstLower_15 = StringExtensions.toFirstLower(_name_27);
    _builder.append(_firstLower_15, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCount(final PojoDao d, final PojoEntity e, final Map<String,List<PojoMethodArg>> toInits, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int count(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"count ");
    String _name_2 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower_1, "    ");
    _builder.append(": \" + ");
    String _name_3 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_2, "    ");
    _builder.append(" + \" \" + sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("SqlQueryEngine sqlEngine");
    String _name_4 = e.getName();
    _builder.append(_name_4, "  ");
    _builder.append(" = sqlEngineFactory.getCheckedQueryEngine(\"SELECT_");
    String _dbName = Utils.dbName(e);
    _builder.append(_dbName, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    {
      boolean _isEmpty = toInits.isEmpty();
      if (_isEmpty) {
        _builder.append("//");
      }
    }
    _builder.append("sqlControl = getMoreResultClasses(");
    String _name_5 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_3, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("int count = sqlEngine");
    String _name_6 = e.getName();
    _builder.append(_name_6, "  ");
    _builder.append(".queryCount(sqlSession, ");
    String _name_7 = e.getName();
    String _firstLower_4 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_4, "  ");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (logger.isTraceEnabled()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("logger.trace(\"count: \" + count);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return count;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int count(");
    String _name_8 = e.getName();
    _builder.append(_name_8, "");
    _builder.append(" ");
    String _name_9 = e.getName();
    String _firstLower_5 = StringExtensions.toFirstLower(_name_9);
    _builder.append(_firstLower_5, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return count(sqlSessionFactory.getSqlSession(), ");
    String _name_10 = e.getName();
    String _firstLower_6 = StringExtensions.toFirstLower(_name_10);
    _builder.append(_firstLower_6, "	");
    _builder.append(", sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int count(SqlSession sqlSession, ");
    String _name_11 = e.getName();
    _builder.append(_name_11, "");
    _builder.append(" ");
    String _name_12 = e.getName();
    String _firstLower_7 = StringExtensions.toFirstLower(_name_12);
    _builder.append(_firstLower_7, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return count(sqlSession, ");
    String _name_13 = e.getName();
    String _firstLower_8 = StringExtensions.toFirstLower(_name_13);
    _builder.append(_firstLower_8, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public int count(");
    String _name_14 = e.getName();
    _builder.append(_name_14, "");
    _builder.append(" ");
    String _name_15 = e.getName();
    String _firstLower_9 = StringExtensions.toFirstLower(_name_15);
    _builder.append(_firstLower_9, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("return count(");
    String _name_16 = e.getName();
    String _firstLower_10 = StringExtensions.toFirstLower(_name_16);
    _builder.append(_firstLower_10, "  ");
    _builder.append(", null);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileMoreResultClasses(final PojoDao d, final PojoEntity e, final Map<String,List<PojoMethodArg>> toInits, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("SqlControl getMoreResultClasses(");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("if (sqlControl != null && sqlControl.getMoreResultClasses() != null)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return sqlControl;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Map<String, Class<?>> moreResultClasses = null;");
    _builder.newLine();
    {
      Set<Entry<String,List<PojoMethodArg>>> _entrySet = toInits.entrySet();
      boolean _hasElements = false;
      for(final Entry<String,List<PojoMethodArg>> f : _entrySet) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        _builder.append("  if (");
        String _name_2 = e.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_2);
        _builder.append(_firstLower_1, "");
        _builder.append(" != null && ");
        String _name_3 = e.getName();
        String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
        _builder.append(_firstLower_2, "");
        _builder.append(".toInit(");
        String _name_4 = e.getName();
        _builder.append(_name_4, "");
        _builder.append(".Association.");
        String _key = f.getKey();
        _builder.append(_key, "");
        _builder.append(".name())) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("if (moreResultClasses == null)");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("moreResultClasses = new HashMap<String, Class<?>>();");
        _builder.newLine();
        {
          List<PojoMethodArg> _value = f.getValue();
          boolean _hasElements_1 = false;
          for(final PojoMethodArg a : _value) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.append("    moreResultClasses.put(\"");
            String _name_5 = a.getName();
            _builder.append(_name_5, "");
            _builder.append("\", ");
            PojoType _type = a.getType();
            PojoEntity _ref = _type.getRef();
            QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_ref);
            _builder.append(_fullyQualifiedName, "");
            _builder.append(".class);");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.append("if (moreResultClasses != null) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("sqlControl = new SqlStandardControl(sqlControl);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("((SqlStandardControl) sqlControl).setMoreResultClasses(moreResultClasses);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return sqlControl;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileIfx(final PojoDao d) {
    StringConcatenation _builder = new StringConcatenation();
    ImportManager _importManager = new ImportManager(true);
    final ImportManager im = _importManager;
    _builder.newLineIfNotEmpty();
    this.addImplements(d, im);
    _builder.newLineIfNotEmpty();
    this.addExtends(d, im);
    _builder.newLineIfNotEmpty();
    PojoEntity _pojo = d.getPojo();
    final CharSequence classBody = this.compileIfx(d, _pojo, im);
    _builder.newLineIfNotEmpty();
    {
      EObject _eContainer = d.eContainer();
      boolean _notEquals = (!Objects.equal(_eContainer, null));
      if (_notEquals) {
        _builder.append("package ");
        EObject _eContainer_1 = d.eContainer();
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_1);
        _builder.append(_fullyQualifiedName, "");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlSession;");
    _builder.newLine();
    _builder.append("import org.sqlproc.engine.SqlControl;");
    _builder.newLine();
    _builder.append("import ");
    PojoEntity _pojo_1 = d.getPojo();
    String _completeName = this.completeName(_pojo_1);
    _builder.append(_completeName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(classBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface ");
    String _name = d.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    {
      EList<PojoMethod> _methods = d.getMethods();
      for(final PojoMethod m : _methods) {
        {
          String _name_1 = m.getName();
          boolean _equals = Objects.equal(_name_1, "scaffold");
          if (_equals) {
            CharSequence _compileInsertIfx = this.compileInsertIfx(d, e, im);
            _builder.append(_compileInsertIfx, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileGetIfx = this.compileGetIfx(d, e, im);
            _builder.append(_compileGetIfx, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileUpdateIfx = this.compileUpdateIfx(d, e, im);
            _builder.append(_compileUpdateIfx, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileDeleteIfx = this.compileDeleteIfx(d, e, im);
            _builder.append(_compileDeleteIfx, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileListIfx = this.compileListIfx(d, e, im);
            _builder.append(_compileListIfx, "  ");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            CharSequence _compileCountIfx = this.compileCountIfx(d, e, im);
            _builder.append(_compileCountIfx, "  ");
            _builder.newLineIfNotEmpty();
          } else {
            boolean _isCallUpdate = Utils.isCallUpdate(m);
            if (_isCallUpdate) {
              _builder.append("  ");
              CharSequence _compileCallUpdateIfx = this.compileCallUpdateIfx(d, m, im);
              _builder.append(_compileCallUpdateIfx, "  ");
            } else {
              boolean _isCallFunction = Utils.isCallFunction(m);
              if (_isCallFunction) {
                CharSequence _compileCallFunctionIfx = this.compileCallFunctionIfx(d, m, im);
                _builder.append(_compileCallFunctionIfx, "  ");
              } else {
                boolean _or = false;
                boolean _isCallQuery = Utils.isCallQuery(m);
                if (_isCallQuery) {
                  _or = true;
                } else {
                  boolean _isCallQueryFunction = Utils.isCallQueryFunction(m);
                  _or = (_isCallQuery || _isCallQueryFunction);
                }
                if (_or) {
                  boolean _isCallQueryFunction_1 = Utils.isCallQueryFunction(m);
                  CharSequence _compileCallQueryIfx = this.compileCallQueryIfx(d, m, im, _isCallQueryFunction_1);
                  _builder.append(_compileCallQueryIfx, "  ");
                } else {
                  boolean _isCallSelectFunction = Utils.isCallSelectFunction(m);
                  if (_isCallSelectFunction) {
                    CharSequence _compileCallSelectFunctionIfx = this.compileCallSelectFunctionIfx(d, m, im);
                    _builder.append(_compileCallSelectFunctionIfx, "  ");
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCallQueryIfx(final PojoDao d, final PojoMethod m, final ImportManager im, final boolean isFunction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_2 = m.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "");
    _builder.append(" ");
    String _name_2 = m.getName();
    _builder.append(_name_2, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_3 = ma_1.getType();
        CharSequence _compileType_3 = this.compileType(_type_3, im);
        _builder.append(_compileType_3, "");
        _builder.append(" ");
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_4 = m.getType();
    CharSequence _compileType_4 = this.compileType(_type_4, im);
    _builder.append(_compileType_4, "");
    _builder.append(" ");
    String _name_4 = m.getName();
    _builder.append(_name_4, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_5 = ma_2.getType();
        CharSequence _compileType_5 = this.compileType(_type_5, im);
        _builder.append(_compileType_5, "");
        _builder.append(" ");
        String _name_5 = ma_2.getName();
        _builder.append(_name_5, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_6 = m.getType();
    CharSequence _compileType_6 = this.compileType(_type_6, im);
    _builder.append(_compileType_6, "");
    _builder.append(" ");
    String _name_6 = m.getName();
    _builder.append(_name_6, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_7 = ma_3.getType();
        CharSequence _compileType_7 = this.compileType(_type_7, im);
        _builder.append(_compileType_7, "");
        _builder.append(" ");
        String _name_7 = ma_3.getName();
        _builder.append(_name_7, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileCallFunctionIfx(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_2 = m.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "");
    _builder.append(" ");
    String _name_2 = m.getName();
    _builder.append(_name_2, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_3 = ma_1.getType();
        CharSequence _compileType_3 = this.compileType(_type_3, im);
        _builder.append(_compileType_3, "");
        _builder.append(" ");
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_4 = m.getType();
    CharSequence _compileType_4 = this.compileType(_type_4, im);
    _builder.append(_compileType_4, "");
    _builder.append(" ");
    String _name_4 = m.getName();
    _builder.append(_name_4, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_5 = ma_2.getType();
        CharSequence _compileType_5 = this.compileType(_type_5, im);
        _builder.append(_compileType_5, "");
        _builder.append(" ");
        String _name_5 = ma_2.getName();
        _builder.append(_name_5, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_6 = m.getType();
    CharSequence _compileType_6 = this.compileType(_type_6, im);
    _builder.append(_compileType_6, "");
    _builder.append(" ");
    String _name_6 = m.getName();
    _builder.append(_name_6, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_7 = ma_3.getType();
        CharSequence _compileType_7 = this.compileType(_type_7, im);
        _builder.append(_compileType_7, "");
        _builder.append(" ");
        String _name_7 = ma_3.getName();
        _builder.append(_name_7, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileCallUpdateIfx(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type = ma.getType();
        CharSequence _compileType = this.compileType(_type, im);
        _builder.append(_compileType, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int ");
    String _name_2 = m.getName();
    _builder.append(_name_2, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma_1.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int ");
    String _name_4 = m.getName();
    _builder.append(_name_4, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_2 = ma_2.getType();
        CharSequence _compileType_2 = this.compileType(_type_2, im);
        _builder.append(_compileType_2, "");
        _builder.append(" ");
        String _name_5 = ma_2.getName();
        _builder.append(_name_5, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int ");
    String _name_6 = m.getName();
    _builder.append(_name_6, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_3 = ma_3.getType();
        CharSequence _compileType_3 = this.compileType(_type_3, im);
        _builder.append(_compileType_3, "");
        _builder.append(" ");
        String _name_7 = ma_3.getName();
        _builder.append(_name_7, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileCallSelectFunctionIfx(final PojoDao d, final PojoMethod m, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type = m.getType();
    CharSequence _compileType = this.compileType(_type, im);
    _builder.append(_compileType, "");
    _builder.append(" ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args = m.getArgs();
      boolean _hasElements = false;
      for(final PojoMethodArg ma : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_1 = ma.getType();
        CharSequence _compileType_1 = this.compileType(_type_1, im);
        _builder.append(_compileType_1, "");
        _builder.append(" ");
        String _name_1 = ma.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_2 = m.getType();
    CharSequence _compileType_2 = this.compileType(_type_2, im);
    _builder.append(_compileType_2, "");
    _builder.append(" ");
    String _name_2 = m.getName();
    _builder.append(_name_2, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_1 = m.getArgs();
      boolean _hasElements_1 = false;
      for(final PojoMethodArg ma_1 : _args_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_3 = ma_1.getType();
        CharSequence _compileType_3 = this.compileType(_type_3, im);
        _builder.append(_compileType_3, "");
        _builder.append(" ");
        String _name_3 = ma_1.getName();
        _builder.append(_name_3, "");
      }
    }
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_4 = m.getType();
    CharSequence _compileType_4 = this.compileType(_type_4, im);
    _builder.append(_compileType_4, "");
    _builder.append(" ");
    String _name_4 = m.getName();
    _builder.append(_name_4, "");
    _builder.append("(SqlSession sqlSession, ");
    {
      EList<PojoMethodArg> _args_2 = m.getArgs();
      boolean _hasElements_2 = false;
      for(final PojoMethodArg ma_2 : _args_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_5 = ma_2.getType();
        CharSequence _compileType_5 = this.compileType(_type_5, im);
        _builder.append(_compileType_5, "");
        _builder.append(" ");
        String _name_5 = ma_2.getName();
        _builder.append(_name_5, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    PojoType _type_6 = m.getType();
    CharSequence _compileType_6 = this.compileType(_type_6, im);
    _builder.append(_compileType_6, "");
    _builder.append(" ");
    String _name_6 = m.getName();
    _builder.append(_name_6, "");
    _builder.append("(");
    {
      EList<PojoMethodArg> _args_3 = m.getArgs();
      boolean _hasElements_3 = false;
      for(final PojoMethodArg ma_3 : _args_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        PojoType _type_7 = ma_3.getType();
        CharSequence _compileType_7 = this.compileType(_type_7, im);
        _builder.append(_compileType_7, "");
        _builder.append(" ");
        String _name_7 = ma_3.getName();
        _builder.append(_name_7, "");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileInsertIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" insert(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append(" insert(");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" insert(SqlSession sqlSession, ");
    String _name_7 = e.getName();
    _builder.append(_name_7, "");
    _builder.append(" ");
    String _name_8 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public ");
    String _name_9 = e.getName();
    _builder.append(_name_9, "");
    _builder.append(" insert(");
    String _name_10 = e.getName();
    _builder.append(_name_10, "");
    _builder.append(" ");
    String _name_11 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_11);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileGetIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" get(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append(" get(");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" get(SqlSession sqlSession, ");
    String _name_7 = e.getName();
    _builder.append(_name_7, "");
    _builder.append(" ");
    String _name_8 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    String _name_9 = e.getName();
    _builder.append(_name_9, "");
    _builder.append(" get(");
    String _name_10 = e.getName();
    _builder.append(_name_10, "");
    _builder.append(" ");
    String _name_11 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_11);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileUpdateIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int update(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int update(");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int update(SqlSession sqlSession, ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int update(");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileDeleteIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int delete(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int delete(");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int delete(SqlSession sqlSession, ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int delete(");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileListIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public List<");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append("> list(SqlSession sqlSession, ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "");
    _builder.append(" ");
    String _name_2 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_2);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public List<");
    String _name_3 = e.getName();
    _builder.append(_name_3, "");
    _builder.append("> list(");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public List<");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append("> list(SqlSession sqlSession, ");
    String _name_7 = e.getName();
    _builder.append(_name_7, "");
    _builder.append(" ");
    String _name_8 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public List<");
    String _name_9 = e.getName();
    _builder.append(_name_9, "");
    _builder.append("> list(");
    String _name_10 = e.getName();
    _builder.append(_name_10, "");
    _builder.append(" ");
    String _name_11 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_11);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileCountIfx(final PojoDao d, final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("public int count(SqlSession sqlSession, ");
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = e.getName();
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int count(");
    String _name_2 = e.getName();
    _builder.append(_name_2, "");
    _builder.append(" ");
    String _name_3 = e.getName();
    String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
    _builder.append(_firstLower_1, "");
    _builder.append(", SqlControl sqlControl);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int count(SqlSession sqlSession, ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = e.getName();
    String _firstLower_2 = StringExtensions.toFirstLower(_name_5);
    _builder.append(_firstLower_2, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public int count(");
    String _name_6 = e.getName();
    _builder.append(_name_6, "");
    _builder.append(" ");
    String _name_7 = e.getName();
    String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
    _builder.append(_firstLower_3, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public List<PojoAnnotatedProperty> listFeatures(final PojoEntity e) {
    ArrayList<PojoAnnotatedProperty> _arrayList = new ArrayList<PojoAnnotatedProperty>();
    final ArrayList<PojoAnnotatedProperty> list = _arrayList;
    PojoEntity _superType = Utils.getSuperType(e);
    boolean _notEquals = (!Objects.equal(_superType, null));
    if (_notEquals) {
      PojoEntity _superType_1 = Utils.getSuperType(e);
      List<PojoAnnotatedProperty> _listFeatures = this.listFeatures(_superType_1);
      list.addAll(_listFeatures);
    }
    List<PojoAnnotatedProperty> _listFeatures1 = this.listFeatures1(e);
    list.addAll(_listFeatures1);
    return list;
  }
  
  public List<PojoAnnotatedProperty> listFeatures1(final PojoEntity e) {
    EList<PojoAnnotatedProperty> _features = e.getFeatures();
    final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
        public Boolean apply(final PojoAnnotatedProperty f) {
          PojoProperty _feature = f.getFeature();
          boolean _isList = Utils.isList(_feature);
          return Boolean.valueOf(_isList);
        }
      };
    Iterable<PojoAnnotatedProperty> _filter = IterableExtensions.<PojoAnnotatedProperty>filter(_features, _function);
    return IterableExtensions.<PojoAnnotatedProperty>toList(_filter);
  }
  
  public List<PojoAnnotatedProperty> requiredFeatures(final PojoEntity e) {
    ArrayList<PojoAnnotatedProperty> _arrayList = new ArrayList<PojoAnnotatedProperty>();
    final ArrayList<PojoAnnotatedProperty> list = _arrayList;
    PojoEntity _superType = Utils.getSuperType(e);
    boolean _notEquals = (!Objects.equal(_superType, null));
    if (_notEquals) {
      PojoEntity _superType_1 = Utils.getSuperType(e);
      List<PojoAnnotatedProperty> _requiredFeatures = this.requiredFeatures(_superType_1);
      list.addAll(_requiredFeatures);
    }
    List<PojoAnnotatedProperty> _requiredFeatures1 = this.requiredFeatures1(e);
    list.addAll(_requiredFeatures1);
    return list;
  }
  
  public ArrayList<PojoAnnotatedProperty> requiredSuperFeatures(final PojoEntity e) {
    ArrayList<PojoAnnotatedProperty> _arrayList = new ArrayList<PojoAnnotatedProperty>();
    final ArrayList<PojoAnnotatedProperty> list = _arrayList;
    PojoEntity _superType = Utils.getSuperType(e);
    boolean _notEquals = (!Objects.equal(_superType, null));
    if (_notEquals) {
      PojoEntity _superType_1 = Utils.getSuperType(e);
      List<PojoAnnotatedProperty> _requiredFeatures = this.requiredFeatures(_superType_1);
      list.addAll(_requiredFeatures);
    }
    return list;
  }
  
  public List<PojoAnnotatedProperty> requiredFeatures1(final PojoEntity e) {
    EList<PojoAnnotatedProperty> _features = e.getFeatures();
    final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
        public Boolean apply(final PojoAnnotatedProperty f) {
          PojoProperty _feature = f.getFeature();
          boolean _isRequired = Utils.isRequired(_feature);
          return Boolean.valueOf(_isRequired);
        }
      };
    Iterable<PojoAnnotatedProperty> _filter = IterableExtensions.<PojoAnnotatedProperty>filter(_features, _function);
    return IterableExtensions.<PojoAnnotatedProperty>toList(_filter);
  }
  
  public PojoAnnotatedProperty hasIsDef(final PojoEntity e) {
    EList<PojoAnnotatedProperty> _features = e.getFeatures();
    final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
        public Boolean apply(final PojoAnnotatedProperty f) {
          PojoProperty _feature = f.getFeature();
          String _name = _feature.getName();
          boolean _equals = Objects.equal(_name, "isDef");
          return Boolean.valueOf(_equals);
        }
      };
    return IterableExtensions.<PojoAnnotatedProperty>findFirst(_features, _function);
  }
  
  public PojoAnnotatedProperty hasToInit(final PojoEntity e) {
    EList<PojoAnnotatedProperty> _features = e.getFeatures();
    final Function1<PojoAnnotatedProperty,Boolean> _function = new Function1<PojoAnnotatedProperty,Boolean>() {
        public Boolean apply(final PojoAnnotatedProperty f) {
          PojoProperty _feature = f.getFeature();
          String _name = _feature.getName();
          boolean _equals = Objects.equal(_name, "toInit");
          return Boolean.valueOf(_equals);
        }
      };
    return IterableExtensions.<PojoAnnotatedProperty>findFirst(_features, _function);
  }
  
  public boolean isAttribute(final PojoProperty f) {
    boolean _or = false;
    boolean _or_1 = false;
    String _native = f.getNative();
    boolean _notEquals = (!Objects.equal(_native, null));
    if (_notEquals) {
      _or_1 = true;
    } else {
      Entity _ref = f.getRef();
      boolean _notEquals_1 = (!Objects.equal(_ref, null));
      _or_1 = (_notEquals || _notEquals_1);
    }
    if (_or_1) {
      _or = true;
    } else {
      JvmType _type = f.getType();
      boolean _notEquals_2 = (!Objects.equal(_type, null));
      _or = (_or_1 || _notEquals_2);
    }
    return _or;
  }
  
  public List<PojoProperty> simplAttrs(final PojoProperty f) {
    EList<PojoProperty> _attrs = f.getAttrs();
    final Function1<PojoProperty,Boolean> _function = new Function1<PojoProperty,Boolean>() {
        public Boolean apply(final PojoProperty f2) {
          boolean _or = false;
          String _native = f2.getNative();
          boolean _notEquals = (!Objects.equal(_native, null));
          if (_notEquals) {
            _or = true;
          } else {
            JvmType _type = f2.getType();
            boolean _notEquals_1 = (!Objects.equal(_type, null));
            _or = (_notEquals || _notEquals_1);
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<PojoProperty> _filter = IterableExtensions.<PojoProperty>filter(_attrs, _function);
    return IterableExtensions.<PojoProperty>toList(_filter);
  }
  
  public CharSequence compileImplements(final EnumEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _sernum = Utils.getSernum(e);
      boolean _notEquals = (!Objects.equal(_sernum, null));
      if (_notEquals) {
        _builder.append("implements Serializable");
      }
    }
    _builder.append(" ");
    return _builder;
  }
  
  public CharSequence compileExtends(final PojoEntity e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      PojoEntity _superType = Utils.getSuperType(e);
      boolean _notEquals = (!Objects.equal(_superType, null));
      if (_notEquals) {
        _builder.append("extends ");
        PojoEntity _superType_1 = Utils.getSuperType(e);
        PojoEntity _superType_2 = Utils.getSuperType(e);
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_superType_2);
        String _fullName = Utils.getFullName(e, _superType_1, _fullyQualifiedName, im);
        _builder.append(_fullName, "");
        _builder.append(" ");
      } else {
        String _extends = this.getExtends(e);
        boolean _notEquals_1 = (!Objects.equal(_extends, ""));
        if (_notEquals_1) {
          _builder.append("extends ");
          String _extends_1 = this.getExtends(e);
          _builder.append(_extends_1, "");
          _builder.append(" ");
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileImplements(final PojoEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _isImplements = this.isImplements(e);
      if (_isImplements) {
        _or = true;
      } else {
        String _sernum = Utils.getSernum(e);
        boolean _notEquals = (!Objects.equal(_sernum, null));
        _or = (_isImplements || _notEquals);
      }
      if (_or) {
        _builder.append("implements ");
        {
          ArrayList<Implements> _implements = this.getImplements(e);
          boolean _hasElements = false;
          for(final Implements f : _implements) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            JvmType _implements_1 = f.getImplements();
            String _simpleName = _implements_1.getSimpleName();
            _builder.append(_simpleName, "");
          }
        }
        {
          String _sernum_1 = Utils.getSernum(e);
          boolean _notEquals_1 = (!Objects.equal(_sernum_1, null));
          if (_notEquals_1) {
            {
              boolean _isImplements_1 = this.isImplements(e);
              if (_isImplements_1) {
                _builder.append(", ");
              }
            }
            _builder.append("Serializable");
          }
        }
        _builder.append(" ");
      }
    }
    return _builder;
  }
  
  public CharSequence compileExtends(final PojoDao e, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    {
      PojoDao _superType = Utils.getSuperType(e);
      boolean _notEquals = (!Objects.equal(_superType, null));
      if (_notEquals) {
        _builder.append("extends ");
        PojoDao _superType_1 = Utils.getSuperType(e);
        PojoDao _superType_2 = Utils.getSuperType(e);
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_superType_2);
        String _fullName = Utils.getFullName(e, _superType_1, _fullyQualifiedName, im);
        _builder.append(_fullName, "");
        _builder.append(" ");
      } else {
        String _extends = this.getExtends(e);
        boolean _notEquals_1 = (!Objects.equal(_extends, ""));
        if (_notEquals_1) {
          _builder.append("extends ");
          String _extends_1 = this.getExtends(e);
          _builder.append(_extends_1, "");
          _builder.append(" ");
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileImplements(final PojoDao d) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _isImplements = this.isImplements(d);
      if (_isImplements) {
        _or_1 = true;
      } else {
        String _sernum = Utils.getSernum(d);
        boolean _notEquals = (!Objects.equal(_sernum, null));
        _or_1 = (_isImplements || _notEquals);
      }
      if (_or_1) {
        _or = true;
      } else {
        String _implPackage = this.getImplPackage(d);
        boolean _notEquals_1 = (!Objects.equal(_implPackage, null));
        _or = (_or_1 || _notEquals_1);
      }
      if (_or) {
        _builder.append("implements ");
        {
          ArrayList<Implements> _implements = this.getImplements(d);
          boolean _hasElements = false;
          for(final Implements f : _implements) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _daoImplements = Utils.getDaoImplements(d, f);
            _builder.append(_daoImplements, "");
          }
        }
        {
          String _sernum_1 = Utils.getSernum(d);
          boolean _notEquals_2 = (!Objects.equal(_sernum_1, null));
          if (_notEquals_2) {
            {
              boolean _isImplements_1 = this.isImplements(d);
              if (_isImplements_1) {
                _builder.append(", ");
              }
            }
            _builder.append("Serializable");
          }
        }
        {
          String _implPackage_1 = this.getImplPackage(d);
          boolean _notEquals_3 = (!Objects.equal(_implPackage_1, null));
          if (_notEquals_3) {
            {
              boolean _or_2 = false;
              boolean _isImplements_2 = this.isImplements(d);
              if (_isImplements_2) {
                _or_2 = true;
              } else {
                String _sernum_2 = Utils.getSernum(d);
                boolean _notEquals_4 = (!Objects.equal(_sernum_2, null));
                _or_2 = (_isImplements_2 || _notEquals_4);
              }
              if (_or_2) {
                _builder.append(", ");
              }
            }
            String _name = d.getName();
            _builder.append(_name, "");
          }
        }
        _builder.append(" ");
      }
    }
    return _builder;
  }
  
  public boolean compile(final Extends e, final ImportManager im) {
    JvmType _extends = e.getExtends();
    boolean _addImportFor = im.addImportFor(_extends);
    return _addImportFor;
  }
  
  public void addImplements(final EnumEntity e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements impl : _filter) {
      JvmType _implements = impl.getImplements();
      im.addImportFor(_implements);
    }
  }
  
  public void addExtends(final EnumEntity e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      im.addImportFor(_extends);
    }
  }
  
  public void addImplements(final PojoEntity e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements impl : _filter) {
      JvmType _implements = impl.getImplements();
      im.addImportFor(_implements);
    }
  }
  
  public void addExtends(final PojoEntity e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      im.addImportFor(_extends);
    }
  }
  
  public void addImplements(final PojoDao e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements impl : _filter) {
      JvmType _implements = impl.getImplements();
      im.addImportFor(_implements);
    }
  }
  
  public void addExtends(final PojoDao e, final ImportManager im) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      im.addImportFor(_extends);
    }
  }
  
  public void addAnnotations(final List<Annotation> annotations, final ImportManager im) {
    for (final Annotation a : annotations) {
      JvmType _type = a.getType();
      im.serialize(_type);
    }
  }
  
  public String getExtends(final EnumEntity e) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      return _extends.getSimpleName();
    }
    return "";
  }
  
  public boolean isImplements(final EnumEntity e) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements ext : _filter) {
      return true;
    }
    return false;
  }
  
  public String getExtends(final PojoEntity e) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      return _extends.getSimpleName();
    }
    return "";
  }
  
  public boolean isImplements(final PojoEntity e) {
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements ext : _filter) {
      {
        EList<PojoEntity> _onlyPojos = ext.getOnlyPojos();
        boolean _isEmpty = _onlyPojos.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          EList<PojoEntity> _onlyPojos_1 = ext.getOnlyPojos();
          for (final PojoEntity ee : _onlyPojos_1) {
            String _name = ee.getName();
            String _name_1 = e.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            if (_equals) {
              return true;
            }
          }
          return false;
        }
        EList<PojoEntity> _exceptPojos = ext.getExceptPojos();
        for (final PojoEntity ee_1 : _exceptPojos) {
          String _name_2 = ee_1.getName();
          String _name_3 = e.getName();
          boolean _equals_1 = Objects.equal(_name_2, _name_3);
          if (_equals_1) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean isImplements(final PojoEntity e, final Implements ext) {
    EList<PojoEntity> _onlyPojos = ext.getOnlyPojos();
    boolean _isEmpty = _onlyPojos.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<PojoEntity> _onlyPojos_1 = ext.getOnlyPojos();
      for (final PojoEntity ee : _onlyPojos_1) {
        String _name = ee.getName();
        String _name_1 = e.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          return true;
        }
      }
      return false;
    }
    EList<PojoEntity> _exceptPojos = ext.getExceptPojos();
    for (final PojoEntity ee_1 : _exceptPojos) {
      String _name_2 = ee_1.getName();
      String _name_3 = e.getName();
      boolean _equals_1 = Objects.equal(_name_2, _name_3);
      if (_equals_1) {
        return false;
      }
    }
    return true;
  }
  
  public ArrayList<Implements> getImplements(final PojoEntity e) {
    ArrayList<Implements> _arrayList = new ArrayList<Implements>();
    final ArrayList<Implements> list = _arrayList;
    EObject _eContainer = e.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements ext : _filter) {
      boolean _isImplements = this.isImplements(e, ext);
      if (_isImplements) {
        list.add(ext);
      }
    }
    return list;
  }
  
  public String getExtends(final PojoDao e) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Extends> _filter = Iterables.<Extends>filter(_eContents, Extends.class);
    for (final Extends ext : _filter) {
      JvmType _extends = ext.getExtends();
      return _extends.getSimpleName();
    }
    return "";
  }
  
  public boolean isImplements(final PojoDao e) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements ext : _filter) {
      {
        EList<PojoDao> _onlyDaos = ext.getOnlyDaos();
        boolean _isEmpty = _onlyDaos.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          EList<PojoDao> _onlyDaos_1 = ext.getOnlyDaos();
          for (final PojoDao ee : _onlyDaos_1) {
            String _name = ee.getName();
            String _name_1 = e.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            if (_equals) {
              return true;
            }
          }
          return false;
        }
        EList<PojoDao> _exceptDaos = ext.getExceptDaos();
        for (final PojoDao ee_1 : _exceptDaos) {
          String _name_2 = ee_1.getName();
          String _name_3 = e.getName();
          boolean _equals_1 = Objects.equal(_name_2, _name_3);
          if (_equals_1) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean isImplements(final PojoDao e, final Implements ext) {
    EList<PojoDao> _onlyDaos = ext.getOnlyDaos();
    boolean _isEmpty = _onlyDaos.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<PojoDao> _onlyDaos_1 = ext.getOnlyDaos();
      for (final PojoDao ee : _onlyDaos_1) {
        String _name = ee.getName();
        String _name_1 = e.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          return true;
        }
      }
      return false;
    }
    EList<PojoDao> _exceptDaos = ext.getExceptDaos();
    for (final PojoDao ee_1 : _exceptDaos) {
      String _name_2 = ee_1.getName();
      String _name_3 = e.getName();
      boolean _equals_1 = Objects.equal(_name_2, _name_3);
      if (_equals_1) {
        return false;
      }
    }
    return true;
  }
  
  public ArrayList<Implements> getImplements(final PojoDao e) {
    ArrayList<Implements> _arrayList = new ArrayList<Implements>();
    final ArrayList<Implements> list = _arrayList;
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<Implements> _filter = Iterables.<Implements>filter(_eContents, Implements.class);
    for (final Implements ext : _filter) {
      boolean _isImplements = this.isImplements(e, ext);
      if (_isImplements) {
        list.add(ext);
      }
    }
    return list;
  }
  
  public String getImplPackage(final PojoDao e) {
    EObject _eContainer = e.eContainer();
    EList<EObject> _eContents = _eContainer.eContents();
    Iterable<ImplPackage> _filter = Iterables.<ImplPackage>filter(_eContents, ImplPackage.class);
    for (final ImplPackage ext : _filter) {
      return ext.getName();
    }
    return null;
  }
  
  public String completeName(final PojoEntity e) {
    String _package = Utils.getPackage(e);
    String _plus = (_package + ".");
    String _name = e.getName();
    return (_plus + _name);
  }
}
