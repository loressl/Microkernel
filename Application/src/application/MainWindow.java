
package application;

public class MainWindow extends javax.swing.JFrame {

	public MainWindow() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		toolBar = new javax.swing.JToolBar();
		menuBar = new javax.swing.JMenuBar();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		toolBar.setRollover(true);
		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				toolBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE,
						25, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 273, Short.MAX_VALUE)));

		pack();
	}

	private javax.swing.JMenuBar menuBar;
	private javax.swing.JToolBar toolBar;

}
