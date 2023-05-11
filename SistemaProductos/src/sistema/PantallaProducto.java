package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaProducto {

	private JFrame frmSistemaproductos;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtProveedor;
	private JButton btnInsertar;
	private JButton btnCargar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProducto window = new PantallaProducto();
					window.frmSistemaproductos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaproductos = new JFrame();
		frmSistemaproductos.setTitle("SistemaProductos");
		frmSistemaproductos.setBounds(100, 100, 450, 300);
		frmSistemaproductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaproductos.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(25, 22, 46, 14);
		frmSistemaproductos.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 51, 46, 14);
		frmSistemaproductos.getContentPane().add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(25, 76, 46, 14);
		frmSistemaproductos.getContentPane().add(lblPrecio);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 107, 61, 14);
		frmSistemaproductos.getContentPane().add(lblProveedor);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtId.getText().length()>=3) {
					e.consume();
				}
			}
		});
		txtId.setBounds(81, 19, 86, 20);
		frmSistemaproductos.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length()>=10) {
					e.consume();
				}
			
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(81, 48, 86, 20);
		frmSistemaproductos.getContentPane().add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPrecio.getText().length()>=5) {
					e.consume();
				}
			
			}
		});
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(81, 73, 86, 20);
		frmSistemaproductos.getContentPane().add(txtPrecio);
		
		txtProveedor = new JTextField();
		txtProveedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtProveedor.getText().length()>=20) {
					e.consume();
				}
				
			}
		});
		txtProveedor.setColumns(10);
		txtProveedor.setBounds(81, 104, 86, 20);
		frmSistemaproductos.getContentPane().add(txtProveedor);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NegocioProducto np=new NegocioProducto();
					np.setId(txtId.getText());
					np.setNombre(txtNombre.getText());
					np.setPrecio(txtPrecio.getText());
					np.setProveedor(txtProveedor.getText());
					if(np.insertarProducto()){
						JOptionPane.showMessageDialog(null, "Producto Agregado");
					}
					else {
						JOptionPane.showMessageDialog(null,"error");
					}
					
				}catch(Exception e2){
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"error");
				}
			}
		});
		btnInsertar.setBounds(10, 188, 89, 23);
		frmSistemaproductos.getContentPane().add(btnInsertar);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id=JOptionPane.showInputDialog("id de producto");
					NegocioProducto c=new NegocioProducto();
					c.setId(id);
					if(c.cargarProducto()){
						JOptionPane.showMessageDialog(null,"Producto Encontrado" );
					}else {

						JOptionPane.showMessageDialog(null,"Erroooor" );
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null , "Error");
				}
			}
		});
		btnCargar.setBounds(121, 188, 89, 23);
		frmSistemaproductos.getContentPane().add(btnCargar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(222, 188, 89, 23);
		frmSistemaproductos.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(335, 188, 89, 23);
		frmSistemaproductos.getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(106, 135, 89, 23);
		frmSistemaproductos.getContentPane().add(btnLimpiar);
	}
}
