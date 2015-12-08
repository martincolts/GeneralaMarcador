package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TablaPuntajes;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Tablero(TablaPuntajes tablaPuntajes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 679, 550);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {
			{"1"},
			{"2"},
			{"3"},
			{"4"},
			{"5"},
			{"6"},
			{"Escalera"},
			{"Full"},
			{"Poker"},
			{"Generala"},
			{"Generala Doble"},
		},
		new String[] {
			"Juegos/Participantes"
		});
		
		table = new JTable(modelo);
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				for (int i = 0 ; i < tablaPuntajes.getListaJugadores().size();i++){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					modelo.addColumn(tablaPuntajes.getListaJugadores().elementAt(i).toString());
				}
			};

		}).start();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		scrollPane.setViewportView(table);
		
		
		
	}
}
