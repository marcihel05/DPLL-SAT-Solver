/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dpll;

import java.awt.CheckboxGroup;
import java.awt.Component;
import java.io.File;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author helena
 */
public class DpllGui extends javax.swing.JFrame {
    
    private Formula formula = new Formula();
    private Formula formulaCopy;
    private String fileName ="";
    private JFileChooser jChooser1 = new JFileChooser();
    private CheckboxGroup checkGroup = new CheckboxGroup();
    private boolean start = true;

    /**
     * Creates new form DpllGui
     */
    public DpllGui() {
        initComponents();
        clausesLabel.setText("");
        propLabel.setText("");
        jChooser1.setCurrentDirectory(new java.io.File("."));
        prettyCheckBox.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        formulaTextArea = new javax.swing.JTextArea();
        checkButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        formulaTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pigeonButton = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        propLabel = new javax.swing.JLabel();
        clausesLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        intTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        prettyCheckBox = new javax.swing.JCheckBox();
        uglyCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setEnabled(false);

        formulaTextArea.setEditable(false);
        formulaTextArea.setColumns(20);
        formulaTextArea.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        formulaTextArea.setRows(5);
        formulaTextArea.setName("formulaTextArea"); // NOI18N
        jScrollPane1.setViewportView(formulaTextArea);

        checkButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        checkButton.setText("Check SAT");
        checkButton.setEnabled(false);
        checkButton.setName("chackButton"); // NOI18N
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        loadButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        loadButton.setText("Load from file");
        loadButton.setName("loadButton"); // NOI18N
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        formulaTextField.setEditable(false);
        formulaTextField.setEnabled(false);
        formulaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formulaTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Input formula in CNF");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setText("or");

        pigeonButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        pigeonButton.setText("Pigeons");
        pigeonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pigeonButtonActionPerformed(evt);
            }
        });

        graphButton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        graphButton.setText("Graph coloring");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setText("<html>Number of<br>propositional variables<html>");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setText("<html>Number of<br>clauses</html>");

        propLabel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        propLabel.setText("jLabel5");

        clausesLabel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        clausesLabel.setText("jLabel6");

        intTextArea.setEditable(false);
        intTextArea.setColumns(20);
        intTextArea.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        intTextArea.setLineWrap(true);
        intTextArea.setRows(5);
        jScrollPane2.setViewportView(intTextArea);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel5.setText("Formula notation");

        prettyCheckBox.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        prettyCheckBox.setText("\\/");
        prettyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prettyCheckBoxActionPerformed(evt);
            }
        });

        uglyCheckBox.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        uglyCheckBox.setText("<-");
        uglyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uglyCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(propLabel)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clausesLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(formulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(loadButton)))
                        .addGap(32, 32, 32)
                        .addComponent(checkButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prettyCheckBox)
                            .addComponent(jLabel5)
                            .addComponent(uglyCheckBox)
                            .addComponent(graphButton)
                            .addComponent(pigeonButton))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(checkButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clausesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pigeonButton)
                        .addGap(18, 18, 18)
                        .addComponent(graphButton)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prettyCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(uglyCheckBox))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        int retVal = jChooser1.showOpenDialog((Component)evt.getSource());
        if( retVal == JFileChooser.APPROVE_OPTION){
            File file = jChooser1.getSelectedFile();
            try{
                fileName = file.toString();
            }
            
            catch(Exception e){}
            File formulaFile = new File(fileName);
            int id = 0;
            HashMap<Integer,ArrayList<Integer>> f = new HashMap<>();
            ArrayList<Integer> prop = new ArrayList<>();
            
            try{
                Scanner reader = new Scanner(formulaFile);
                while(reader.hasNextLine() ){
                    String line = reader.nextLine(); 
                    var lineSplit = line.split(" ");
                    System.out.println(lineSplit.length);
                    if(lineSplit.length == 1) lineSplit = line.split("  ");
                    if(lineSplit.length == 4 && "p".equals(lineSplit[0])){ //header, num of prop var and num of clauses
                        propLabel.setText(lineSplit[2]);
                        clausesLabel.setText(lineSplit[3]);
                    }
                    else if(lineSplit.length > 0 && !"c".equals(lineSplit[0]) && !"p".equals(lineSplit[0])){ //clause
                        ArrayList<Integer> c = new ArrayList<>();
                        for(int i = 0; i < lineSplit.length-1; ++i){ //last number is 0, it means end of clause
                            int l = Integer.parseInt(lineSplit[i]);
                            if(!prop.contains(abs(l))) prop.add(abs(l));
                            c.add(l);
                        }
                        f.put(id, c);
                        ++id;
                    }
                }
            }
            catch(Exception e){}
            //var lit = countLiterals(f,prop);
            start = false;
            formula = new Formula(prop,f);
            formulaCopy = formula.copy();
            if(prettyCheckBox.isSelected()) formulaTextArea.setText(formula.toString());
            else formulaTextArea.setText(formula.toStringUgly());
            intTextArea.setText("");
            checkButton.setEnabled(true);
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        if(!"".equals(formulaTextField.getText())){
            //parse formula
        }
        Dpll dpllAlg = new Dpll(formula);
        long startTime = System.nanoTime();
        Pair rez = dpllAlg.start();
        long endTime = System.nanoTime();
        System.out.println(rez.getDecision());
        if(rez.getDecision()){
            intTextArea.setText("Formula is\nsatisfiable!\n" + rez.getInterpretation().toString());
            boolean checkResult = checkInterpretation(rez.getInterpretation(), formulaCopy);
            if(!checkResult) intTextArea.append("\nSomething went wrong!!!");
        }
        else intTextArea.setText("Formula is\nunsatisfiable!");
        System.out.println(endTime-startTime);
        
    }//GEN-LAST:event_checkButtonActionPerformed

    private void formulaTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formulaTextFieldKeyReleased
        if(!"".equals(formulaTextField.getText())) checkButton.setEnabled(true);
        else checkButton.setEnabled(false);
    }//GEN-LAST:event_formulaTextFieldKeyReleased

    private void pigeonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pigeonButtonActionPerformed
        // TODO add your handling code here:
        PigeonFrame frame = new PigeonFrame();
        frame.setGUI(this);
        frame.setVisible(true);
    }//GEN-LAST:event_pigeonButtonActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        // TODO add your handling code here:
        GraphFrame frame = new GraphFrame();
        frame.setGUI(this);
        frame.setVisible(true);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void prettyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prettyCheckBoxActionPerformed
        // TODO add your handling code here:
        if(start) {
            uglyCheckBox.setSelected(false);
            return;
        }
        uglyCheckBox.setSelected(false);
        formulaTextArea.setText(formula.toString());
    }//GEN-LAST:event_prettyCheckBoxActionPerformed

    private void uglyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uglyCheckBoxActionPerformed
        // TODO add your handling code here:
        if(start) {
            prettyCheckBox.setSelected(false);
            return;
        }
        prettyCheckBox.setSelected(false);
        formulaTextArea.setText(formula.toStringUgly());
    }//GEN-LAST:event_uglyCheckBoxActionPerformed
        
    public HashMap<Integer,Set<Integer>> countLiterals(HashMap<Integer,ArrayList<Integer>> f, ArrayList<Integer> propVar){
        HashMap<Integer,Set<Integer>> ret = new HashMap<>();
        var keys = f.keySet().toArray(new Integer[0]);
        for(int p: propVar){
            Set<Integer> sp = new TreeSet<>();
            Set<Integer> sm = new TreeSet<>();
            for(int i = 0; i < keys.length; ++i){
                ArrayList<Integer> clause = f.get(keys[i]);
                for( int j = 0; j < clause.size(); ++j){
                    if(clause.get(j) == p){
                        sp.add(keys[i]);
                    }
                    if(clause.get(j) == -p){
                        sm.add(keys[i]);
                    }
                }
            }
            ret.put(p, sp);
            ret.put(-p,sm);
        }
        return ret;
    }
    
    public boolean checkInterpretation(Interpretation i, Formula f){
        var clauses = formula.getClauses(); //hashMap
        for(var c : clauses.entrySet()){ 
            boolean disj = false;
            for(var l:c.getValue()){ //list
                disj = disj || i.getLiteralAssignment(l);
            }
            if(!disj){
                System.out.println("krivo!!");
                System.out.println(c.getKey());
                return false;
            }
        }
        return true;
        
    }
    
    public void setFormulaText(String text){
        formulaTextArea.setText(text);
    }
    
    public void setIntText(String text){
        intTextArea.setText(text);
    }
    
    public void setPropLabel(String text){
        propLabel.setText(text);
    }
    
    public void setClausesLabel(String text){
        clausesLabel.setText(text);
    }
    
    
        private HashMap<Integer, ArrayList<Integer>> test(){
       HashMap<Integer,ArrayList<Integer>> l = new HashMap<>();
        ArrayList<Integer> d = new ArrayList<Integer>(){{
            add(-1);add(3);add(4);
        }};
        l.put(0,d);
        d = new ArrayList<Integer>(){{
            add(-2);add(6);add(4);
        }};
        l.put(1,d);
        d = new ArrayList<Integer>(){{
            add(-2);add(-6);add(-3);
        }};
        l.put(2,d);
        d = new ArrayList<Integer>(){{
            add(-4);add(-2);
        }};
        l.put(3,d);
        d = new ArrayList<Integer>(){{
            add(2); add(-3); add(-1);
        }};
        l.put(4,d);
        d = new ArrayList<Integer>(){{
            add(2);add(6);add(3);
        }};
        l.put(5,d);
        d = new ArrayList<Integer>(){{
            add(2);add(-6);add(-4);
        }};
        l.put(6,d);
        d = new ArrayList<Integer>(){{
            add(1);add(5);
        }};
        l.put(7,d);
        d = new ArrayList<Integer>(){{
            add(1);add(6);
        }};
        l.put(8,d);
        d = new ArrayList<Integer>(){{
            add(-6);add(3);add(-5);
        }};
        l.put(9,d);
        d = new ArrayList<Integer>(){{
            add(1);add(-3);add(-5);
        }};
        l.put(10,d);
       return l;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DpllGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DpllGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DpllGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DpllGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DpllGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel clausesLabel;
    private javax.swing.JTextArea formulaTextArea;
    private javax.swing.JTextField formulaTextField;
    private javax.swing.JButton graphButton;
    private javax.swing.JTextArea intTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton pigeonButton;
    private javax.swing.JCheckBox prettyCheckBox;
    private javax.swing.JLabel propLabel;
    private javax.swing.JCheckBox uglyCheckBox;
    // End of variables declaration//GEN-END:variables
}
