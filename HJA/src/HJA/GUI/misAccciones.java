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
		case "22":
			vtnPlayers.insertaRamdom(0);		
			break;
		case "23":
			vtnPlayers.insertaRamdom(1);		
			break;
		case "24":
			vtnPlayers.insertaRamdom(2);		
			break;
		case "25":
			vtnPlayers.insertaRamdom(3);		
			break;
		case "26":
			vtnPlayers.insertaRamdom(4);		
			break;
		case "27":
			vtnPlayers.insertaRamdom(5);		
			break;
		case "28":
			vtnPlayers.insertaRamdom(6);		
			break;
		case "29":
			vtnPlayers.insertaRamdom(7);		
			break;
		case "30":
			vtnPlayers.insertaRamdom(8);		
			break;
		case "31":
			vtnPlayers.insertaRamdom(9);		
			break;
		case "32"://seleccionar mano
			vtnSeleccionCartas= new GUISeleccionCartas(vtnPlayers.getControl(),vtnPlayers.getAccion(),0, vtnPlayers.getBoard());
			vtnSeleccionCartas.getFrmSeleccionarCartas().setVisible(true);
			break;
		case "33"://seleccionar descartes
			vtnSeleccionCartas= new GUISeleccionCartas(vtnPlayers.getControl(),vtnPlayers.getAccion(),0, vtnPlayers.getDescartes());
			vtnSeleccionCartas.getFrmSeleccionarCartas().setVisible(true);
			break;
		case "34"://calcular
			String[] rangos=vtnPlayers.getRangos();
			if(rangos.length>1)
				vtnPlayers.insertaEquity(vtnPlayers.getControl().calcularEquity(vtnPlayers.getBoard(), vtnPlayers.getDescartes(), rangos));
			break;
		case "35"://Limpiar ventana
			vtnPlayers.limpiarVentana();
			break;
		case "36"://ayuda
	
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
			//vtnPlayers.getTfMano().setText(vtnSeleccionCartas.leerMano());
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
