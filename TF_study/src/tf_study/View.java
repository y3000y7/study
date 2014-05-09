package tf_study;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	private Label label;
	private Button btn;
	@Override
	public void createPartControl(Composite parent) {
		label = new Label(parent,SWT.SINGLE);
		label.setText("tf study");
		btn= new Button(parent,SWT.SINGLE);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
