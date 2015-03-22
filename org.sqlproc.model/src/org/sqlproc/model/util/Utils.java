package org.sqlproc.model.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.sqlproc.model.processorModel.Artifacts;
import org.sqlproc.model.processorModel.FunctionDefinition;
import org.sqlproc.model.processorModel.Package;
import org.sqlproc.model.processorModel.ProcedureDefinition;
import org.sqlproc.model.processorModel.TableDefinition;
import org.sqlproc.plugin.lib.util.CommonUtils;

public class Utils extends CommonUtils {

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

	public static Set<String> getImports(Package packagex, ISerializer serializer) {
		Set<String> imports = new HashSet<String>();
		if (packagex.getImportSection() != null && packagex.getImportSection().getImportDeclarations() != null) {
			for (XImportDeclaration imp : packagex.getImportSection().getImportDeclarations()) {
				imports.add(CommonUtils.removeBlankLines(serializer.serialize(imp)).substring(7));
			}
		}
		return imports;
	}
}
