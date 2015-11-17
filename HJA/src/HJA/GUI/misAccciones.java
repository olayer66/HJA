package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class misAccciones implements ActionListener 
{
	private GUIPlayers  vtnPlayers;
	private GUIRango vtnRango;
	
	//Constructores
	public misAccciones(GUIPlayers  vtn)
	{
		vtnPlayers=vtn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "1":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[0].getText()),0);
			vtnRango.getFrame().setVisible(true);
			break;
		case "2":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[1].getText()),1);
			vtnRango.getFrame().setVisible(true);
			break;
		case "3":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[2].getText()),2);
			vtnRango.getFrame().setVisible(true);
			break;
		case "4":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[3].getText()),3);
			vtnRango.getFrame().setVisible(true);
			break;
		case "5":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[4].getText()),4);
			vtnRango.getFrame().setVisible(true);
			break;
		case "6":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[5].getText()),5);
			vtnRango.getFrame().setVisible(true);
			break;
		case "7":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[6].getText()),6);
			vtnRango.getFrame().setVisible(true);
			break;
		case "8":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[7].getText()),7);
			vtnRango.getFrame().setVisible(true);
			break;
		case "9":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[8].getText()),8);
			vtnRango.getFrame().setVisible(true);
			break;
		case "10":
			vtnRango= new GUIRango(vtnPlayers,vtnPlayers.getControl(),vtnPlayers.getControl().transformarString(vtnPlayers.getTfRango()[9].getText()),9);
			vtnRango.getFrame().setVisible(true);
			break;
		default:
			break;
		}
		
	}

}
