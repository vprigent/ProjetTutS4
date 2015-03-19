package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.GraphHandler;
import controller.Controller;


public class MainFrame extends JFrame implements Observer {

    private Controller controller;
    private GraphHandler model;

    private JComboBox<String> algorithms;

    private JComboBox<String> displayMode;
    private DrawingPanel mainPanel;

    public MainFrame(Controller controller) {
        this.controller = controller;
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
        JMenuBar toolBar = new JMenuBar();
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Fichiers");
        JMenuItem newButton = new JMenuItem();
        JMenuItem loadButton = new JMenuItem();
        JMenuItem saveButton = new JMenuItem();

        JMenu modifier = new JMenu("Modifier");
        JMenuItem removeButton = new JMenuItem();
        JMenuItem undo = new JMenuItem("Annuler");
        JMenuItem redo = new JMenuItem("Répéter");

		displayMode = new JComboBox<String>();
		algorithms = new JComboBox<String>();

        JMenuItem zoomIn = new JMenuItem();
        JMenuItem zoomOut = new JMenuItem();
        JMenuItem copy = new JMenuItem();
        JMenuItem cut = new JMenuItem();
        JMenuItem paste = new JMenuItem();
        JMenuItem add = new JMenuItem();
        JMenuItem delete = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Graph Drawer");
		setMinimumSize(new java.awt.Dimension(800, 400));
		setName("MainFrame"); // NOI18N
		setPreferredSize(new java.awt.Dimension(800, 600));

        fileMenu.add(newButton);
        fileMenu.add(loadButton);
        fileMenu.add(saveButton);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        modifier.add(removeButton);
        modifier.add(undo);
        modifier.add(redo);
        menuBar.add(modifier);

        this.setLocationRelativeTo(null);

        toolBar.setVisible(true);
        this.setContentPane(toolBar);

		newButton.setBackground(new java.awt.Color(65, 65, 65));
		newButton.setFocusable(false);
		newButton.setText("Nouveau");
		newButton.setName("new"); // NOI18N
		newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

		loadButton.setBackground(new java.awt.Color(65, 65, 65));
		loadButton.setFocusable(false);
		loadButton.setText("Charger");
		loadButton.setName("load"); // NOI18N
		loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

		saveButton.setBackground(new java.awt.Color(65, 65, 65));
		saveButton.setFocusable(false);
		saveButton.setText("Sauvegarder");
		saveButton.setName("save"); // NOI18N
		saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

		removeButton.setBackground(new java.awt.Color(65, 65, 65));
		removeButton.setFocusable(false);
		removeButton.setText("Supprimer");
		removeButton.setName("remove"); // NOI18N
		removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

		GroupLayout menuBarLayout = new GroupLayout(menuBar);

		undo.setIcon(new ImageIcon(getClass().getResource(
                "icons/DataContainer_MovePreviousHS.png"))); // NOI18N
		undo.setFocusPainted(false);
		undo.setFocusable(false);
		undo.setName("undo"); // NOI18N
		undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

		redo.setIcon(new ImageIcon(getClass().getResource(
                "icons/DataContainer_MoveNextHS.png"))); // NOI18N
		redo.setFocusPainted(false);
		redo.setFocusable(false);
		redo.setName("undo"); // NOI18N
		redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

		displayMode.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Tout afficher", "Sommets", "Arrêtes" }));
		displayMode.setFocusable(false);
		displayMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				displayModeItemStateChanged(evt);
			}
		});

		algorithms.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Aucun Algorithme", "Aleatoire", "Circulaire",
				"Modele de force", "Colorisation", "Calcul d'indice", "Taille",
				"Personnalisé" }));
		algorithms.setFocusable(false);
		algorithms.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				algorithmsItemStateChanged(evt);
			}
		});

		zoomIn.setIcon(new ImageIcon(getClass().getResource("icons/zoomIn.png"))); // NOI18N
		zoomIn.setFocusable(false);
		zoomIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });

		zoomOut.setIcon(new ImageIcon(getClass().getResource(
                "icons/zoomOut.png"))); // NOI18N
		zoomOut.setFocusable(false);
		zoomOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });

		copy.setIcon(new ImageIcon(getClass().getResource("icons/copy.png"))); // NOI18N
		copy.setFocusable(false);
		copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

		cut.setIcon(new ImageIcon(getClass().getResource("icons/cut.png"))); // NOI18N
		cut.setFocusable(false);
		cut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });

		paste.setIcon(new ImageIcon(getClass().getResource("icons/paste.png"))); // NOI18N
		paste.setFocusable(false);
		paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });

		add.setIcon(new ImageIcon(getClass().getResource("icons/add.png"))); // NOI18N
		add.setToolTipText("");
		add.setFocusable(false);
		add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

		delete.setIcon(new ImageIcon(getClass().getResource("icons/delete.png"))); // NOI18N
		delete.setFocusable(false);
		delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

		GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
        mainPanel.setLocation(0, 70);

		pack();
	}// </editor-fold>

	// Actions
	private void newButtonActionPerformed(ActionEvent evt) {
		System.out.println("new");
	}

	private void loadButtonActionPerformed(ActionEvent evt) {
		System.out.println("load");
        controller.addDrawingController().getGraph().loadGraph();
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
			System.out.println(displayMode.getSelectedItem());
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

}
