package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class misAccciones implements ActionListener 
{
	private GUIPlayers  vtnPlayers;
	private GUIRango vtnRango;
	private String prueba;
	
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
		
		//A partir de aqui son acciones de GUIRango
		case "11":
			//Esto para el controlador
			vtnPlayers.insertaRango(vtnRango.getRangoSelec().toArray(),vtnRango.getJugador());
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
		default:
			break;
		}
		
	}

}
