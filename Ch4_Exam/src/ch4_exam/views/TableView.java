package ch4_exam.views;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import ch4_exam.TF;
import ch4_exam.TableLabelProvider;

public class TableView extends ViewPart {

	public void createPartControl(Composite parent) {
		final TableViewer tableViewer = new TableViewer(parent, SWT.SINGLE
				| SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] columnNames = new String[] { "Name", "Roll", "Gender"};
		int[] columnWidths = new int[] { 100, 100, 100};
		int[] columnAlignments = new int[] { SWT.CENTER, SWT.CENTER, SWT.CENTER};

		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table,
					columnAlignments[i]);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}
		
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(TF.example());
	}

	public void setFocus() {
		
	}
}