import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;


public class Visitor implements IResourceProxyVisitor,IResourceDeltaVisitor{

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		// incremental build
		String name=delta.getResource().getName();
		if(name.endsWith(".chris")){
			System.out.print("processing.." +name);
			processResource(delta.getResource());
		}
		return true;
	}

	@Override
	public boolean visit(IResourceProxy proxy) throws CoreException {
		// full build
		return true;
	}
	
	private void processResource(IResource resource) throws CoreException {
		resource.deleteMarkers("TF_Study2.marker",true,IResource.DEPTH_INFINITE);
		
		IFile file=(IFile) resource;
		String fileName=file.getName().replace(".chris", ".nousco");
		IContainer container=file.getParent();
		IFile newFile = container.getFile(new Path(fileName));
		newFile.create(null, true, null);
		
		if(fileName.contains("1")){
			IMarker marker=resource.createMarker("TF_Study2.marker");
			marker.setAttribute(IMarker.SEVERITY,IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.LINE_NUMBER,0);
			marker.setAttribute(IMarker.MESSAGE,".chris file must be only character ");
			marker.setAttribute(IMarker.CHAR_START,0);
			marker.setAttribute(IMarker.CHAR_END,0);
		}
	}

}
