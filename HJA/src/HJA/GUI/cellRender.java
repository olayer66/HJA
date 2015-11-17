package HJA.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;

public class cellRender extends javax.swing.table.DefaultTableCellRenderer 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	public cellRender(Color miColor)
	{
		color=miColor;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cellComponent.setBackground(color);
        return cellComponent;
    }
}
