package view;


import controller.Controller;
import model.Edge;
import model.Graph;
import model.GraphHandler;
import model.Node;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;


public class MainFrame extends JFrame implements Observer {

    private Controller controller;
    private GraphHandler model;

    private JComboBox<String> algorithms;
    private JComboBox<String> displayMode;

    private DrawingPanel mainPanel;
    private JFileChooser jFileChooser;

    public MainFrame(Controller controller) {
        this.controller = controller;
        controller.setMainFrame(this);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        mainPanel = new DrawingPanel(controller.addDrawingController());

        jFileChooser = new JFileChooser();

        JMenuBar menuBar = new JMenuBar();
        JToolBar toolBar = new JToolBar();

        JMenu fileMenu = new JMenu("Fichiers");
        JMenuItem newButton = new JMenuItem("Nouveau");
        JMenuItem loadButton = new JMenuItem("Charger");
        JMenuItem saveButton = new JMenuItem("Sauvegarder");

        JMenu modifier = new JMenu("Modifier");
        JMenuItem remove = new JMenuItem("Tout supprimer");
        JMenuItem undo = new JMenuItem("Annuler");
        JMenuItem redo = new JMenuItem("Répéter");

        JMenu about = new JMenu("A propos");
        JMenuItem help = new JMenuItem("Aide");

        displayMode = new JComboBox<String>();
        algorithms = new JComboBox<String>();

        JButton zoomIn = new JButton();
        JButton zoomOut = new JButton();
        JButton copy = new JButton();
        JButton cut = new JButton();
        JButton paste = new JButton();
        JButton add = new JButton();
        JButton delete = new JButton();
        JButton undoButton = new JButton();
        JButton redoButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Drawer");
        setMinimumSize(new Dimension(800, 400));
        setName("MainFrame");
        setPreferredSize(new Dimension(800, 600));

        // add elements on menu bar
        fileMenu.add(newButton);
        fileMenu.add(loadButton);
        fileMenu.add(saveButton);
        menuBar.add(fileMenu);

        modifier.add(remove);
        modifier.add(undo);
        modifier.add(redo);
        menuBar.add(modifier);
        this.setJMenuBar(menuBar);

        toolBar.add(zoomIn);
        toolBar.add(zoomOut);
        toolBar.add(displayMode);
        toolBar.add(algorithms);
        toolBar.add(copy);
        toolBar.add(cut);
        toolBar.add(paste);
        toolBar.add(add);
        toolBar.add(delete);
        toolBar.add(undoButton);
        toolBar.add(redoButton);
        toolBar.setFloatable(false);
        this.add(toolBar, BorderLayout.PAGE_START);
        this.add(mainPanel, BorderLayout.CENTER);


        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        undo.setIcon(new ImageIcon(getClass().getResource(
                "icons/DataContainer_MovePreviousHS.png")));
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        undoButton.setIcon(undo.getIcon());
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setIcon(new ImageIcon(getClass().getResource(
                "icons/DataContainer_MoveNextHS.png")));
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        redoButton.setIcon(redo.getIcon());
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        displayMode.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Tout afficher", "Sommets", "Arrêtes"}));
        displayMode.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                displayModeItemStateChanged(evt);
            }
        });

        algorithms.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Aucun Algorithme", "Aleatoire", "Circulaire",
                "Modele de force", "Colorisation", "Calcul d'indice", "Taille",
                "Personnalisé"}));
        algorithms.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                algorithmsItemStateChanged(evt);
            }
        });

        zoomIn.setIcon(new ImageIcon(getClass().getResource("icons/zoomIn.png")));
        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });

        zoomOut.setIcon(new ImageIcon(getClass().getResource("icons/zoomOut.png")));
        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });

        copy.setIcon(new ImageIcon(getClass().getResource("icons/copy.png")));
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        cut.setIcon(new ImageIcon(getClass().getResource("icons/cut.png")));
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });

        paste.setIcon(new ImageIcon(getClass().getResource("icons/paste.png")));
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });

        add.setIcon(new ImageIcon(getClass().getResource("icons/add.png"))); //
        add.setToolTipText("");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setIcon(new ImageIcon(getClass().getResource("icons/delete.png")));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>

    // Actions
    private void newButtonActionPerformed(ActionEvent evt) {
        System.out.println("new");
    }

    private void loadButtonActionPerformed(ActionEvent evt) {
        int returnVal = jFileChooser.showOpenDialog(this);
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Graph files", "xml", "dot", "graphml"));
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String selectedFile = jFileChooser.getSelectedFile().getName();
            controller.getGraphHandler().addGraph(new Graph(selectedFile));
        }
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        System.out.println("save");

    }

    private void removeButtonActionPerformed(ActionEvent evt) {
        controller.removeAllNodes();
        mainPanel.repaint();
    }

    private void undoActionPerformed(ActionEvent evt) {
        System.out.println("undo");
    }

    private void redoActionPerformed(ActionEvent evt) {
        System.out.println("redo");
    }

    private void displayModeItemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        }
    }

    private void algorithmsItemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            controller.applyAlgorithm(algorithms.getSelectedItem().toString());
        }

        repaint();
    }

    private void zoomInActionPerformed(ActionEvent evt) {
        System.out.println("zoomIn");
    }

    private void zoomOutActionPerformed(ActionEvent evt) {
        System.out.println("zoomOut");
    }

    private void copyActionPerformed(ActionEvent evt) {
        System.out.println("copy");
    }

    private void cutActionPerformed(ActionEvent evt) {
        System.out.println("cut");
    }

    private void pasteActionPerformed(ActionEvent evt) {
        System.out.println("paste");
    }

    private void addActionPerformed(ActionEvent evt) {
        System.out.println("add");
    }

    private void deleteActionPerformed(ActionEvent evt) {
        controller.removeSelectedNodes();
        repaint();
    }

    private void drawGraph() {
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void repaint() {
        drawGraph();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        model = (GraphHandler) arg1;
        revalidate();
        repaint();
    }

    public DrawingPanel getDrawingPanel() {
        return mainPanel;
    }

    public void createDialogNode(Node n) {
        new DialogProperties(this, "Changement de noeud", false, n);
    }

    public void createDialogEdge(Edge e) {
        new DialogPropertiesEdge(this, "Changement d'arête", false, e);
    }
}
