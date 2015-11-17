package HJA.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class cellRender extends DefaultTableCellRenderer 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -430286226522739411L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected) 
        {
            setBackground( Color.MAGENTA);
        } 
        else 
        {
            setBackground(table.getBackground());
        }
        return this;
    }
}
