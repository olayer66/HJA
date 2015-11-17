package HJA.GUI;

import java.awt.EventQueue;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import HJA.constante;
import HJA.constante.datosMano;
import HJA.controlador.controlador;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;
import java.awt.Font;

public class GUIRango {

	private JFrame frmSeleccionDeRango;
	private controlador control;
	
	//Objetos
	private JTable JtRango;
	private String[] rango;
	private GUIPlayers vtnPlayers;
	private int jugador;
	private JTextField tfRango;
	//Constructor
	public GUIRango(GUIPlayers miGUI, controlador miCont,String[] rng,int player)
	{
		control=miCont;
		rango=rng;
		vtnPlayers=miGUI;
		jugador=player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionDeRango = new JFrame();
		frmSeleccionDeRango.setTitle("Seleccion de rango");
		frmSeleccionDeRango.setBounds(100, 100, 397, 448);
		frmSeleccionDeRango.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSeleccionDeRango.getContentPane().setLayout(null);
		
		//inicializadores de los objetos
				creaTablaRangos();
				
				JtRango.setBounds(10, 11, 356, 208);
				JtRango.setRowSelectionAllowed(false);
				JtRango.setFont(new Font("Tahoma", Font.BOLD, 11));
				JtRango.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				JtRango.setBackground(new Color(240, 230, 140));
			//  Override default renderer on a specific Class
		        TableCellRenderer colorRenderer = new cellRender();
		        JtRango.setDefaultRenderer(String.class, colorRenderer);

		        //  Override default renderer for a specific column
		        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        JtRango.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				frmSeleccionDeRango.getContentPane().add(JtRango);
				
				JLabel lblRangoSeleccionado = new JLabel("Rango seleccionado:");
				lblRangoSeleccionado.setBounds(10, 230, 99, 14);
				frmSeleccionDeRango.getContentPane().add(lblRangoSeleccionado);
				
				tfRango = new JTextField();
				tfRango.setBackground(new Color(255, 255, 255));
				tfRango.setEnabled(false);
				tfRango.setEditable(false);
				tfRango.setBounds(112, 227, 254, 20);
				frmSeleccionDeRango.getContentPane().add(tfRango);
				tfRango.setColumns(10);
	}

	//Crea la tabala de rangos.
		private void creaTablaRangos()
		{
			Object[][] data;
			String[] names ={"","","","","","","","","","","","",""};
			data= new String[13][13];
			java.util.Iterator<Entry<String, datosMano>> it = constante.getInstance().getManos().entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String, datosMano> e=it.next();
				data[e.getValue().getX()][e.getValue().getY()]=e.getKey();

			}
			DefaultTableModel model = new DefaultTableModel(data, names);
			JtRango= new JTable(model){
		        private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        };
		        @SuppressWarnings("unchecked")
				@Override
	            public Class getColumnClass(int column) {
	                return getValueAt(0, column).getClass();
	            }
			};
			
		}
	
	//Getters y setters
	public JFrame getFrame() 
	{
		return frmSeleccionDeRango;
	}

	public JTable getJtRango() {
		return JtRango;
	}

	public void setJtRango(JTable jtRango) {
		JtRango = jtRango;
	}
	
}
