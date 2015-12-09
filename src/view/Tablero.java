package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import controller.Jugador;
import controller.Punto;
import controller.TablaPuntajes;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;

	/**
	 * Create the frame.
	 */
	public Tablero(TablaPuntajes tablaPuntajes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
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
				for (int i = 0 ; i < 11 ; i++){
					for (int j = 1 ; j <=tablaPuntajes.getListaJugadores().size();j++){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						modelo.setValueAt(0, i, j);
					}
				}
				table.getModel().addTableModelListener(
						new TableModelListener() 
						{
						    public void tableChanged(TableModelEvent evt) 
						    {
						    	int col =evt.getColumn();
						    	int fil =evt.getFirstRow();
						    	
						     /*   
								try {
									Punto p = new Punto ((int)modelo.getValueAt(fil, col),col,fil);
									tablaPuntajes.getJugadores().elementAt(col-1).getPuntos().addPunto(p);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						         */
						    }
						});
				
			};

		}).start();
		
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		
		JButton btnAgregarPuntaje = new JButton("Agregar Puntaje");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAgregarPuntaje))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAgregarPuntaje)
							.addGap(314))))
		);
		contentPane.setLayout(gl_contentPane);
		
	/*	table.getModel().addTableModelListener(
				new TableModelListener() 
				{
				    public void tableChanged(TableModelEvent evt) 
				    {
				    	int col =evt.getColumn();
				    	int fil =evt.getFirstRow();
				    	
				    	System.out.println(modelo.getValueAt(fil, col));
				         //Punto p = new Punto ((int)evt.getSource(),col,fil);
				         
				    }
				});*/
	
	
	}
}
