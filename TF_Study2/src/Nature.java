
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class Nature implements IProjectNature {
	public static final String ID="TF_Study2.nature";
	private IProject project;

	public void configure() throws CoreException {
		IProjectDescription desc=project.getDescription();
		List<ICommand> commands = new ArrayList<ICommand>(Arrays.asList(desc.getBuildSpec()));
		Iterator<ICommand> iterator=commands.iterator();
		while(iterator.hasNext()){
			ICommand command=iterator.next();
			if(Builder.ID.equals(command.getBuilderName())){
				return;
			}
		}
		ICommand newCommand=desc.newCommand();
		newCommand.setBuilderName(Builder.ID);
		commands.add(newCommand);
		desc.setBuildSpec(commands.toArray(new ICommand[0]));
		project.setDescription(desc, null);

	}

	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public IProject getProject() {
		// TODO Auto-generated method stub
		return project;
	}

	public void setProject(IProject project) {
		// TODO Auto-generated method stub
		this.project=project;
	}

}