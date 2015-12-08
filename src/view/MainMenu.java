package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controller.TablaPuntajes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {
	
	private JFrame frame;
	private TablaPuntajes tablaPuntajes = new TablaPuntajes();
	public static JList<String> list ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 699, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 33, 120, 316);
		frame.getContentPane().add(scrollPane);
		
		list = new JList<String>(tablaPuntajes.getListaJugadores());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnNuevoParticipante = new JButton("Agregar Jugador");
		btnNuevoParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AgregarJugador (tablaPuntajes).setVisible(true);
			}
		});
		btnNuevoParticipante.setBounds(174, 31, 128, 23);
		frame.getContentPane().add(btnNuevoParticipante);
		
		JButton btnEliminar = new JButton("Eliminar Jugador");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jugadorAEliminar = list.getSelectedValue();
				tablaPuntajes.eliminarJugador(jugadorAEliminar);
				
			}
		});
		btnEliminar.setBounds(174, 91, 128, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tablero(tablaPuntajes).setVisible(true);
			}
		});
		btnEmpezar.setBounds(551, 377, 89, 23);
		frame.getContentPane().add(btnEmpezar);
	}
}
