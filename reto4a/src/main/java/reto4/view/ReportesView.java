package reto4.view;

import reto4.controller.ReportesController;
import reto4.model.vo.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class ReportesView extends JFrame implements ActionListener{
        private ReportesController controller;
        private JButton btnC1, btnC2, btnC3;                       
        private DefaultTableModel modelo;
        private JTable table;
        private JLabel lblTitulo, lblConsulta;

        public ReportesView(){
            controller = new ReportesController();
            etiqueta1();
            botones();
            etiqueta2();
            tabla();

        }
        public void etiqueta1(){
            lblTitulo = new JLabel("Consultas Ciclo2 - Reto 5");
            lblTitulo.setPreferredSize(new Dimension(500, 30));
            lblTitulo.setFont(new Font("Arial", Font.BOLD,20));
            lblTitulo.setHorizontalAlignment(JLabel.CENTER);
            lblTitulo.setBorder(new EmptyBorder(0, 10, 0, 0));
            add(lblTitulo);

        }
        
        public void etiqueta2(){
            lblConsulta = new JLabel();
            lblConsulta.setPreferredSize(new DimensionUIResource(500, 30));
            lblConsulta.setFont(new Font("Arial", Font.BOLD,14));
            add(lblConsulta);
        }

        public void tabla(){
            table = new JTable(modelo);
            table.setPreferredScrollableViewportSize(new Dimension(500,200));
            add(table);
            JScrollPane pane = new JScrollPane(table);
            add(pane);
        }

        public void botones(){
            btnC1 = new JButton("Informe 1");
            btnC1.setBounds(30, 150, 100, 30);
            add(btnC1);
            btnC1.addActionListener(this);

            btnC2 = new JButton("Informe 2");
            btnC2.setBounds(180, 150, 100, 30);
            add(btnC2);
            btnC2.addActionListener(this);

            btnC3 = new JButton("Informe 3");
            btnC3.setBounds(330, 150, 100, 30);
            add(btnC3);
            btnC3.addActionListener(this);
        }

        public void informe1Lider() {
            try{
                List<Consulta1Vo> lideres = controller.listarInforme1Lider();
                // creación del modelo
                modelo = new DefaultTableModel();
                modelo.addColumn("Id");
                modelo.addColumn("Nombre");
                modelo.addColumn("Apellido");
                modelo.addColumn("Ciudad");
                for(Consulta1Vo com: lideres){
                    Object[] fila = new Object[4];
                    fila[0]=com.getId();
                    fila[1]=com.getNombre();
                    fila[2]=com.getApellido();
                    fila[3]=com.getCiudad();
                    modelo.addRow(fila);
                }
                table.setModel(modelo);
                modelo.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        public void informe2Proyectos() {
            try{
                List<Consulta2Vo> proyectos = controller.listarInforme2Proyectos();
                modelo = new DefaultTableModel();
                modelo.addColumn("Id Proyecto");
                modelo.addColumn("Constructora");
                modelo.addColumn("Habitaciones");
                modelo.addColumn("Ciudad");
                for (Consulta2Vo proy : proyectos){
                    Object[] fila = new Object[4];
                    fila[0] = proy.getId();
                    fila[1] = proy.getConstructora();
                    fila[2] = proy.getHabitaciones();
                    fila[3] = proy.getCiudad();
                    modelo.addRow(fila);                    
                }
                table.setModel(modelo);
                modelo.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }
        public void informe3Compras() {
            try{
                List<Consulta3Vo> compras = controller.listarInforme3Compras();
                modelo = new DefaultTableModel();
                modelo.addColumn("Id compra");
                modelo.addColumn("Constructora");
                modelo.addColumn("Banco");
                for (Consulta3Vo compra : compras){
                    Object[] fila = new Object[3];
                    fila[0] = compra.getId();
                    fila[1] = compra.getConstructora();
                    fila[2] = compra.getBanco();
                    modelo.addRow(fila);                    
                }
                table.setModel(modelo);
                modelo.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnC1){
            informe1Lider();
            lblConsulta.setText("Consulta Lideres");
        }
        if(e.getSource() == btnC2){
            informe2Proyectos();
            lblConsulta.setText("Consulta proyectos casa campestre");
        }
        if(e.getSource() == btnC3){
            informe3Compras();
            lblConsulta.setText("Consulta compras por proyectos");
        }
    }
}
