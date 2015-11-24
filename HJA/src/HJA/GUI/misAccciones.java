package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class misAccciones implements ActionListener 
{
	private GUIPlayers  vtnPlayers;
	private GUIRango vtnRango;
	private GUISeleccionCartas vtnSeleccionCartas;
	//Constructores
	public misAccciones(GUIPlayers  vtn)
	{
		vtnPlayers=vtn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "1":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(0)),0);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "2":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(1)),1);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "3":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(2)),2);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "4":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(3)),3);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "5":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(4)),4);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "6":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(5)),5);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "7":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(6)),6);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "8":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(7)),7);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "9":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(8)),8);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		case "10":
			if(vtnRango==null)
			{
				vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.miRango(9)),9);
				vtnRango.getFrame().setVisible(true);
			}
			break;
		//Apartado 2
		case "17":
			 JComboBox<Integer> cb=(JComboBox<Integer>) e.getSource();
			 switch (cb.getSelectedItem().toString()) 
			 {
				case "1":
					vtnPlayers.cambiaVentana(1);
					break;
				case "2":
					vtnPlayers.cambiaVentana(2);
					break;
		
				default:
					break;
			}
			break;
		case "18":
			vtnPlayers.EjecutarCalculo();
			break;
		case "19":
			if(vtnSeleccionCartas==null)
			{
				vtnPlayers.getTfMano().setText("");
				vtnSeleccionCartas=new GUISeleccionCartas(vtnPlayers.getControl(),this);
				vtnSeleccionCartas.getFrmSeleccionarCartas().setVisible(true);
			}
			break;
		
		//A partir de aqui son acciones de GUIRango
		case "11":
			//Esto para el controlador
			vtnPlayers.insertaRango(vtnPlayers.getControl().transformarRango(vtnRango.getRangoSelec().toArray(new String[vtnRango.getRangoSelec().size()])),vtnRango.getJugador());
			vtnRango.getFrame().setVisible(false);
			vtnRango.getFrame().dispose();
			vtnRango=null;
			break;
		case "12":
			//Esto para el controlador
			vtnRango.getFrame().setVisible(false);
			vtnRango.getFrame().dispose();
			vtnRango=null;
			break;
		case "13":
			vtnRango.seleccionaTodas();
			break;
		case "14":
			vtnRango.seleccionaPares();
			break;
		case "15":
			vtnRango.limpiarSeleccion();
			break;
		case "16":
			JComboBox<String> cbRango= (JComboBox<String>) e.getSource();
			vtnRango.setRango(cbRango.getSelectedIndex());
			break;
		
		//Apartir de aqui son de GUISelecionCartas
		case "20":
			vtnPlayers.getTfMano().setText(vtnSeleccionCartas.leerMano());
			vtnSeleccionCartas.getFrmSeleccionarCartas().setVisible(false);
			vtnSeleccionCartas.getFrmSeleccionarCartas().dispose();
			vtnSeleccionCartas=null;
			break;
		case "21":
			vtnSeleccionCartas.getFrmSeleccionarCartas().setVisible(false);
			vtnSeleccionCartas.getFrmSeleccionarCartas().dispose();
			vtnSeleccionCartas=null;
			break;
		default:
			break;
		}
		
	}

}
