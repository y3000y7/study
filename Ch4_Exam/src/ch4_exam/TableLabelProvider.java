package ch4_exam;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


public class TableLabelProvider extends LabelProvider implements ITableLabelProvider{

	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		TF tf=(TF) element;
		switch(columnIndex){
		case 0:
			return tf.name;
		case 1:
			return tf.roll;
		case 2:
			return tf.gender;
		default:
				return "unknown " + columnIndex;
		}
	}

}
