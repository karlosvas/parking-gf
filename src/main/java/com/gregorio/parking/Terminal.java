package com.gregorio.parking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.gregorio.parking.utils.FondoPanel;
import com.gregorio.parking.utils.Validation;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Terminal extends javax.swing.JFrame {
    private static final Integer[][] parking=new Integer[3][20];
    public Maquina maquina;

    /**
     * Constructor de la clase Terminal, que inicializa los componentes de la interfaz gráfica y se comunica
     * con el usuario para generar tickets y retirar vehículos del parking.
     * 
     * @param maquina Objeto de la clase Maquina que contiene la lógica de negocio
     */
    public Terminal(Maquina maquina) {
        // Atributos
        this.maquina = maquina;

        // Fondo global
        FondoPanel fondo = new FondoPanel("/background.jpg");
        this.setContentPane(fondo);

        // Inicio de componentes
        initComponents();
        // Fondo de ticket
        FondoPanel fondoTicket = new FondoPanel("/papel3.jpg");
        this.scroll_ticket.setViewportView(fondoTicket);

        // Lo centramos
        setLocationRelativeTo(null);
        setTitle("Parking Terminal");
        // Para inicializar con 0 (en vez de null), necesitas hacerlo manualmente
        for (Integer[] row : parking)
            Arrays.fill(row, 0);
        
        // Recargamos el array del parking para mostrarlo
        mostrarParking();
        // Recargamos el array de deposito para mostrarlo
        mostrarDeposito();

        // Deshabilitamos los botones
        this.generaticket.setEnabled(false);
        this.retirarvehiculo.setEnabled(false);
        // Le ponemos la fecha actual al campo de fecha
        this.fecha.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    /**
     * Metodo que se encarga de iniciar todos los componentes de la interfaz grafica.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitor = new javax.swing.JPanel();
        generaticket = new javax.swing.JButton();
        retirarvehiculo = new javax.swing.JButton();
        text_matricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        text_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        scroll_ticket = new javax.swing.JScrollPane();
        parking_esquema = new javax.swing.JScrollPane();
        deposito = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        monitor.setBorder(javax.swing.BorderFactory.createTitledBorder("Parking"));

        generaticket.setText("Generar Ticket");
        generaticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaticketActionPerformed(evt);
            }
        });

        retirarvehiculo.setText("Retirar Vehiculo");
        retirarvehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarvehiculoActionPerformed(evt);
            }
        });

        text_matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_matriculaActionPerformed(evt);
            }
        });
        text_matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_matriculaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Matricula:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("ID:");

        text_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_idKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Fecha Salida:");

        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("(1111ABC)");

        javax.swing.GroupLayout monitorLayout = new javax.swing.GroupLayout(monitor);
        monitor.setLayout(monitorLayout);
        monitorLayout.setHorizontalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitorLayout.createSequentialGroup()
                .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monitorLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(generaticket))
                    .addGroup(monitorLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retirarvehiculo)
                            .addGroup(monitorLayout.createSequentialGroup()
                                .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(text_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(monitorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha)
                            .addGroup(monitorLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(49, 49, 49))
                            .addComponent(text_id, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        monitorLayout.setVerticalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generaticket)
                .addGap(18, 18, 18)
                .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retirarvehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monitorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(monitorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addContainerGap(58, Short.MAX_VALUE))))
        );

        scroll_ticket.setToolTipText("Tickets");

        parking_esquema.setToolTipText("Parking");

        deposito.setToolTipText("Deposito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deposito)
                    .addComponent(parking_esquema)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(monitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(parking_esquema, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deposito, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Muestra el parking en la interfaz del Jpanel y pinta de verde las plazas ocupadas.
     * utiliza el arry de arrays de parking para mostrarlo.
     */
    private void mostrarParking() {
        // Configuramos los títulos de las columnas del JTable
        String[] titulosColumnas = new String[parking[0].length];
        Arrays.fill(titulosColumnas, "");
        
        // Creamos el modelo de datos
        DefaultTableModel modeloTabla = new DefaultTableModel(parking, titulosColumnas);
        
        // Creamos el JTable con ese modelo
        JTable tabla = new JTable(modeloTabla);
        
        // Ocultamos el encabezado 
        tabla.getTableHeader().setVisible(false);
        tabla.getTableHeader().setPreferredSize(new Dimension(0, 0));
        
        // Hacemos la tabla transparente para que se vea el fondo
        tabla.setOpaque(false);
        tabla.setBackground(new Color(0, 0, 0, 0));
        
        // Establecemos el tamaño de celda uniforme para mejor visualizacion
        tabla.setRowHeight(45);
        tabla.setRowMargin(20);
        
        // Creamos un renderer personalizado para colorear y centrar las celdas
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Si la celda tiene un valor diferente de 0, la pintamos de verde
                if (value != null && !value.equals(0))
                    cell.setBackground(new Color(144, 238, 144)); // Verde claro
                else 
                    cell.setBackground(new Color(0, 0, 0, 0)); // Transparente
                return cell;
            }
        };
        
        // Centramos el texto
        customRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Aplicamos el renderer a todas las columnas
        for (int i = 0; i < tabla.getColumnCount(); i++)
            tabla.getColumnModel().getColumn(i).setCellRenderer(customRenderer);

        // Añadimos la tabla al ScrollPane para que se muestre
        parking_esquema.setViewportView(tabla);
        
        // Para hacer como un refresco de la vista
        parking_esquema.revalidate();
        this.repaint();
    }
    
    /**
     * Muestra los tickets en la vista de la terminal, resaltando el ticket actual en verde.
     * @param ticketActual Ticket actual que se está procesando
     * @param listTicket Lista de tickets a mostrar
     */
    private void mostrarTickets(Ticket ticketActual, ArrayList<Ticket> listTicket) {
        // Títulos de las columnas
        String[] titulosColumnas = {"ID", "Matricula", "Ubicación", "Fecha Entrada"};
        titulosColumnas[0] = "ID";
        titulosColumnas[1] = "Matricula";
        titulosColumnas[2] = "Ubicación";
        titulosColumnas[3] = "Fecha Entrada";

        // Contenido de los tickets
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String[][] contenidoTicket = new String[listTicket.size()][titulosColumnas.length];
        for (int j = 0; j < listTicket.size(); j++) {
            int posicionTicket = listTicket.size() - 1 - j;
            contenidoTicket[j][0] = String.valueOf(listTicket.get(posicionTicket).getId());
            contenidoTicket[j][1] = listTicket.get(posicionTicket).getMatricula();
            contenidoTicket[j][2] = listTicket.get(posicionTicket).getUbicacion().toString();
            contenidoTicket[j][3] = listTicket.get(posicionTicket).getFechaHoraEntrada().format(formatter);
        }
    
        // Creamos el modelo de datos
        DefaultTableModel modeloTablaTicket = new DefaultTableModel(contenidoTicket, titulosColumnas);
    
        // Creamos el JTable con ese modelo
        JTable tablaTicket = new JTable(modeloTablaTicket);
        tablaTicket.getTableHeader().setPreferredSize(new Dimension(50, 35));

        // Center the header text
        ((DefaultTableCellRenderer) tablaTicket.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Hacemos la tabla transparente para que se vea el fondo
        tablaTicket.setOpaque(false);
        tablaTicket.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        // Creamos un renderer personalizado para resaltar el ticket actual
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Comprobamos si esta fila corresponde al ticket actual
                String idCelda = (String) table.getValueAt(row, 0); // Columna ID
                // Resaltamos la fila del ticket actual
                if (idCelda.equals(String.valueOf(ticketActual.getId()))) 
                    cell.setBackground(new Color(144, 238, 144)); // Verde claro
                else 
                    cell.setBackground(new Color(0, 0, 0, 0)); // Dejamos transparente el resto                    
                return cell;
            }
        };
        
        // Centramos el texto
        customRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Aplicamos el renderer a todas las columnas
        for (int col = 0; col < tablaTicket.getColumnCount(); col++)
            tablaTicket.getColumnModel().getColumn(col).setCellRenderer(customRenderer);
        
        // Creamos un panel transparente que contenga la tabla
        JPanel panelConTabla = new JPanel(new BorderLayout());
        panelConTabla.setOpaque(false); // Panel transparente
        panelConTabla.add(tablaTicket.getTableHeader(), BorderLayout.NORTH);
        panelConTabla.add(tablaTicket, BorderLayout.CENTER);
        
        // Recuperamos el panel de fondo que ya está establecido
        FondoPanel fondoTicket = (FondoPanel) scroll_ticket.getViewport().getView();
        fondoTicket.setLayout(new BorderLayout());
        
        // Limpiamos componentes anteriores y añadimos la nueva tabla
        fondoTicket.removeAll();
        fondoTicket.add(panelConTabla, BorderLayout.CENTER);
        fondoTicket.revalidate();
        
        // Para hacer como un refresco de la vista
        this.repaint();
    }
    /**
     * Muestra el deposito en la interfaz del Jpanel
     */
    private void mostrarDeposito() {
        Map<Double,Double> dinero = maquina.getDeposito().getDinero();
        Double[] tiposCambio = Deposito.getTiposcambio();

        // Configuramos los títulos de las columnas del JTable
        String[] titulosColumnas = new String[tiposCambio.length+1];
        int i = 0;
        for (Double tipo : tiposCambio)
            titulosColumnas[i++] = String.valueOf(tipo);
        titulosColumnas[i] = "Total";
        
        String[][] contenido = new String[1][tiposCambio.length+1];
        int j = 0;
        double total = 0;
        for (Double tipo : tiposCambio) {
            contenido[0][j++] = String.valueOf(dinero.get(tipo));
            total += dinero.get(tipo) * tipo;
        }
        contenido[0][j] = String.valueOf(total + "€");

        // Creamos el modelo de datos
        DefaultTableModel modeloTabla = new DefaultTableModel(contenido, titulosColumnas);
        
        // Creamos el JTable con ese modelo
        JTable tabla = new JTable(modeloTabla);
        
        // Personalizamos el encabezado
        tabla.getTableHeader().setPreferredSize(new Dimension(50, 35)); // Altura del header
        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Centrar texto del header
        // Fuente del header
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Hacemos la tabla transparente para que se vea el fondo
        tabla.setOpaque(false);
        tabla.setBackground(new Color(0, 0, 0, 0));
        
        // Establecemos el tamaño de celda uniforme para mejor visualización
        tabla.setRowHeight(50);
        tabla.setRowMargin(20);

        // Creamos un renderer personalizado para colorear y centrar las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        // Centramos el texto
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Aplicamos el renderer a todas las columnas
        for (int k = 0; k < tabla.getColumnCount(); k++) 
            tabla.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);

        // Añdimos la tabla al ScrollPane para que se muestre
        this.deposito.setViewportView(tabla);
        
        // Para hacer como un refresco de la vista
        this.deposito.revalidate();
        this.repaint();
    }

    // Eventos
    private void generaticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaticketActionPerformed
        // Ubicacion del coche (ubicacion)
        ArrayList<Ticket> listaTickets = maquina.getTickets();
        
        // Buscamos si hemos encontrado algun hueco libre
        Ticket encontradoId = maquina.generarTicket(parking, this.text_matricula.getText());

        // Si no hay plazas libres mostramos un mensaje de error
        if(encontradoId == null){
            JOptionPane.showMessageDialog(
                this, 
                "No hay plazas libres", 
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
            //En caso de que la matricula este repetida mensaje de error        
        } else if(Validation.matriculaRepettida(this.text_matricula.getText(), listaTickets)) {
            JOptionPane.showMessageDialog(
                this, 
                "Matricula repetida",
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE
            );
            parking[encontradoId.getUbicacion().getPlanta()-1][encontradoId.getUbicacion().getPlaza()-1] = 0;
            return;
        }

        // Actualizamos la fecha a la generada por el ticket nuevo, ya que si se genera un ticket en esa fecha quiere decir que es esa fecha
        // Añadimos un segundo para que sea un segundo mas que el ticket de entrada y no de error al retirarlo
        this.fecha.setText(LocalDateTime.now().plusSeconds(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        // Si todo a salido bien añadimos el ticket a la lista de tickets
        listaTickets.add(encontradoId);
        maquina.setTickets(listaTickets);

        System.out.println("Ticket: " + encontradoId);
        
        // Actualizamos la vista del parking y del ticket
        mostrarParking();
        mostrarTickets(encontradoId, maquina.getTickets());
    }//GEN-LAST:event_generaticketActionPerformed
    
    private void retirarvehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarvehiculoActionPerformed
        // Ya estan validados porque solo se puede entrar aqui si id y fecha son correctos
        // Obtenemos el id del ticket (id)
        Integer id = Validation.parseInteger(this.text_id.getText());
        // Obtenemos la fecha de salida (fechaFin)
        LocalDateTime fechaFin = Validation.parseLocalDateTime(this.fecha.getText());
       

        // Buscamos el ticket en la lista de tickets (tickets)
        ArrayList<Ticket> tickets = maquina.getTickets();
        // Precio que el usuario va a tener que pagar
        double precioTicket = 0;
        Ticket selecionado = null;    
        for (Ticket ticket : tickets) {
            if (id == ticket.getId()) {
                precioTicket = maquina.calcularPrecioTicket(ticket, fechaFin);
                selecionado = ticket;
                break;
            }
        }
        
        if(selecionado == null){
            JOptionPane.showMessageDialog(
                this, 
                "No se ha encontrado el ticket con esa ID", 
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // Si la fecha no existe o es menor que la de entrada
        if(fechaFin.isBefore(selecionado.getFechaHoraEntrada())) {
            // Versión basica con icono de error y título
            JOptionPane.showMessageDialog(
                this, 
                "La fecha de salida no puede ser menor o igual que la fecha de entrada", 
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Cantidad que el usuario debe pagar
        JOptionPane.showMessageDialog(this, "   Pagar: " + precioTicket + "€");
        
         // Creamos un panel con los billetes y monedas que se pueden introducir
        JPanel panel = new JPanel(new GridLayout(9, 2)); 
        JTextField veintebillete = new JTextField("0", 5);
        JTextField diezbillete = new JTextField("0", 5);
        JTextField cincobillete = new JTextField("0", 5);
        JTextField unomoneda = new JTextField("0", 5);
        JTextField dosmoneda = new JTextField("0", 5);
        JTextField cincuentacent = new JTextField("0", 5);
        JTextField veintecent = new JTextField("0", 5);
        JTextField diezcent = new JTextField("0", 5);
        JTextField cincocent = new JTextField("0", 5);

        // Añadimos los campos al panel
        panel.add(new JLabel("20€"));
        panel.add(veintebillete);
        panel.add(new JLabel("10€"));
        panel.add(diezbillete);
        panel.add(new JLabel("5€"));
        panel.add(cincobillete);
        panel.add(new JLabel("2€"));
        panel.add(dosmoneda);
        panel.add(new JLabel("1€"));
        panel.add(unomoneda);
        panel.add(new JLabel("0.50€"));
        panel.add(cincuentacent);
        panel.add(new JLabel("0.20€"));
        panel.add(veintecent);
        panel.add(new JLabel("0.10€"));
        panel.add(diezcent);
        panel.add(new JLabel("0.05€"));
        panel.add(cincocent);

        // Obtenemos el resultado de la ventana
        int resultado = JOptionPane.showConfirmDialog(this, panel, 
                    "Total a pagar: " + precioTicket + "€", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario pulsa OK se procesa el pago
        if (resultado == JOptionPane.OK_OPTION) {
            Double[] listaBilletesIntroducidos = new Double[9];
            listaBilletesIntroducidos[0] = Validation.parseDouble(veintebillete.getText());
            listaBilletesIntroducidos[1] = Validation.parseDouble(diezbillete.getText());
            listaBilletesIntroducidos[2] = Validation.parseDouble(cincobillete.getText());
            listaBilletesIntroducidos[3] = Validation.parseDouble(dosmoneda.getText());
            listaBilletesIntroducidos[4] = Validation.parseDouble(unomoneda.getText());
            listaBilletesIntroducidos[5] = Validation.parseDouble(cincuentacent.getText());
            listaBilletesIntroducidos[6] = Validation.parseDouble(veintecent.getText());
            listaBilletesIntroducidos[7] = Validation.parseDouble(diezcent.getText());
            listaBilletesIntroducidos[8] = Validation.parseDouble(cincocent.getText());

            // Total pagado por el usuario (totalPagado)
            double totalPagado = 0;
            // Obtenemos los tipos de cambio almacenado en deposito (tiposCambio)
            Double[] tiposCambio = Deposito.getTiposcambio();
            // Multiplicamos los billetes introducidos por los tipos de cambio y sumamos el total,
            // los dos estan ordenados de la misma forma de mayor a menor
            int i = 0;
            for(Double billete : listaBilletesIntroducidos)
                totalPagado += billete * tiposCambio[i++];
               
            // Procesamos el pago
            boolean pagadoCorrectamente = maquina.getDeposito().procesarPago(totalPagado, precioTicket, listaBilletesIntroducidos);
    
            if(!pagadoCorrectamente) {
                JOptionPane.showMessageDialog(
                    this, 
                    "No se ha pagado correctamente", 
                    "Error de validación", 
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Mostramos el deposito por consola para ver que se ha pagado correctamente
            System.out.println(maquina.getDeposito());

            // Retiramos el viculo y actualizamos el array
            maquina.retirarVehiculo(selecionado);
            parking[selecionado.getUbicacion().getPlanta()-1][selecionado.getUbicacion().getPlaza()-1] = 0;

            // Actualizamos los datos de la vista
            mostrarParking();
            mostrarTickets(selecionado, tickets);
            mostrarDeposito();
        }
            

    }//GEN-LAST:event_retirarvehiculoActionPerformed

    private void text_matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_matriculaActionPerformed
    }//GEN-LAST:event_text_matriculaActionPerformed

    private void text_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_idKeyTyped
    }//GEN-LAST:event_text_idKeyTyped

    /**
     * Comprueba si el ID introducido es valido y habilita el boton de retirar vehículo.
     * @param evt KeyEvent que se produce al escribir en el campo de ID
     */
    private void text_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_idKeyReleased
        // Si el campo de ID y fecha no estan vacios, habilitamos el boton de retirar vehiculo
        Integer id = Validation.parseInteger(this.text_id.getText());
        if (id != null && id > 0) {
            this.retirarvehiculo.setEnabled(true);

            // Buscamos el ticket en la lista de tickets
            Ticket selected = Ticket.getTicketById(id, maquina.getTickets());

            // Si existe el ticket lo pintamos de verde
            if(selected != null)
                mostrarTickets(selected, maquina.getTickets());
        } else 
            this.retirarvehiculo.setEnabled(false);
    }//GEN-LAST:event_text_idKeyReleased

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
    }//GEN-LAST:event_fechaActionPerformed
    
    /**
     * Comprueba si la fecha introducida es valida y habilita el boton de retirar vehículo.
     * @param evt KeyEvent que se produce al escribir en el campo de fecha
     */
    private void fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyReleased
        LocalDateTime fechaFin = Validation.parseLocalDateTime(this.fecha.getText());
        if (fechaFin != null)
            this.retirarvehiculo.setEnabled(true);
        else 
            this.retirarvehiculo.setEnabled(false);
    }//GEN-LAST:event_fechaKeyReleased
   
    /**
     * Comprueba si la matrícula introducida es válida y habilita el botón de generar ticket.
     * @param evt KeyEvent que se produce al escribir en el campo de matrícula
     */
    private void text_matriculaKeyReleased(java.awt.event.KeyEvent evt) {
        // Convertir el texto a mayúsculas
        String textoOriginal = this.text_matricula.getText().toUpperCase();
        this.text_matricula.setText(textoOriginal);

        // Validar la matrícula para saber si es un formato valido y habilitar el botón
        if (Validation.validarMatricula(this.text_matricula.getText()))
            this.generaticket.setEnabled(true);
        else 
            this.generaticket.setEnabled(false);
    }                                                                                
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane deposito;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton generaticket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel monitor;
    private javax.swing.JScrollPane parking_esquema;
    private javax.swing.JButton retirarvehiculo;
    private javax.swing.JScrollPane scroll_ticket;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextField text_matricula;
    // End of variables declaration//GEN-END:variables
}
