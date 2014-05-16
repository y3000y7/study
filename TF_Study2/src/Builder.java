import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;


public class Builder extends IncrementalProjectBuilder {
	public static final String ID="TF_Study2.builder";
	public Builder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		if(kind==FULL_BUILD){
			fullBuild(getProject(),monitor);
		}else{
			incrementalBuild(getProject(), monitor, getDelta(getProject()));
		}
		return null;
	}
	
	private void fullBuild(IProject project,IProgressMonitor monitor){
		System.out.println("doing a full build..");
	}
	
	private void incrementalBuild(IProject project,IProgressMonitor monitor,IResourceDelta delta) throws CoreException{
		delta.accept(new Visitor());
	}

}
