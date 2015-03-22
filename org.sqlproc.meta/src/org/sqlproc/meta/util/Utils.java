package org.sqlproc.meta.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.sqlproc.meta.processorMeta.Artifacts;
import org.sqlproc.meta.processorMeta.Column;
import org.sqlproc.meta.processorMeta.ExtendedColumn;
import org.sqlproc.meta.processorMeta.ExtendedMappingItem;
import org.sqlproc.meta.processorMeta.FunctionDefinition;
import org.sqlproc.meta.processorMeta.MappingColumn;
import org.sqlproc.meta.processorMeta.MappingRule;
import org.sqlproc.meta.processorMeta.MetaStatement;
import org.sqlproc.meta.processorMeta.PojoDefinition;
import org.sqlproc.meta.processorMeta.ProcedureDefinition;
import org.sqlproc.meta.processorMeta.TableDefinition;
import org.sqlproc.plugin.lib.util.CommonUtils;

public class Utils extends CommonUtils {

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

	public static Map<String, PojoDefinition> findPojos(IQualifiedNameConverter qualifiedNameConverter,
	        Artifacts artifacts, IScope scope) {
		Map<String, PojoDefinition> pojos = new HashMap<String, PojoDefinition>();
		Iterable<IEObjectDescription> iterable = scope.getAllElements();
		for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
			IEObjectDescription description = iter.next();
			EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
			if (obj instanceof PojoDefinition)
				pojos.put(((PojoDefinition) obj).getName(), (PojoDefinition) obj);
		}
		return pojos;
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

	public static List<TableDefinition> findTables(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
	        IScope scope) {
		List<TableDefinition> tables = new ArrayList<TableDefinition>();
		Iterable<IEObjectDescription> iterable = scope.getAllElements();
		for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
			IEObjectDescription description = iter.next();
			EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
			if (obj instanceof TableDefinition)
				tables.add((TableDefinition) obj);
		}
		return tables;
	}

	public static List<FunctionDefinition> findFunctions(IQualifiedNameConverter qualifiedNameConverter,
	        Artifacts artifacts, IScope scope) {
		List<FunctionDefinition> functions = new ArrayList<FunctionDefinition>();
		Iterable<IEObjectDescription> iterable = scope.getAllElements();
		for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
			IEObjectDescription description = iter.next();
			EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
			if (obj instanceof FunctionDefinition)
				functions.add((FunctionDefinition) obj);
		}
		return functions;
	}

	public static List<ProcedureDefinition> findProcedures(IQualifiedNameConverter qualifiedNameConverter,
	        Artifacts artifacts, IScope scope) {
		List<ProcedureDefinition> procedures = new ArrayList<ProcedureDefinition>();
		Iterable<IEObjectDescription> iterable = scope.getAllElements();
		for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
			IEObjectDescription description = iter.next();
			EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
			if (obj instanceof ProcedureDefinition)
				procedures.add((ProcedureDefinition) obj);
		}
		return procedures;
	}

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

	public static boolean isFinal(MetaStatement m) {
		String finalToken = getTokenFromModifier(m, "final");
		if (finalToken != null)
			return true;
		return false;
	}

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
}
