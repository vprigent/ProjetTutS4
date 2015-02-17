package view;

import java.util.Observable;
import java.util.Observer;

import model.GraphHandler;

import javax.swing.*;

public class MainFrame extends JFrame implements Observer {

	private GraphHandler model;

	// Variables declaration
	private JButton add;
	private JComboBox algorithms;
	private JButton copy;
	private JButton cut;
	private JButton delete;
	private JComboBox displayMode;
	private JButton loadButton;
	private JPanel mainPanel;
	private JPanel menuBar;
	private JButton newButton;
	private JButton paste;
	private JButton redo;
	private JButton removeButton;
	private JButton saveButton;
	private JPanel toolBar;
	private JButton undo;
	private JButton zoomIn;
	private JButton zoomOut;

	// End of variables declaration

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame(GraphHandler model) {
		this.model = model;
		this.setVisible(true);
		initComponents();
	}

	// Generated code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new JPanel();
        toolBar = new JPanel();
        menuBar = new JPanel();
        newButton = new JButton();
        loadButton = new JButton();
        saveButton = new JButton();
        removeButton = new JButton();
        undo = new JButton();
        redo = new JButton();
        displayMode = new JComboBox();
        algorithms = new JComboBox();
        zoomIn = new JButton();
        zoomOut = new JButton();
        copy = new JButton();
        cut = new JButton();
        paste = new JButton();
        add = new JButton();
        delete = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Drawer");
        setMinimumSize(new java.awt.Dimension(800, 400));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        mainPanel.setName("MainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPanelMouseClicked(evt);
            }
        });

        toolBar.setBackground(new java.awt.Color(65, 65, 65));

        menuBar.setBackground(new java.awt.Color(65, 65, 65));

        newButton.setBackground(new java.awt.Color(65, 65, 65));
        newButton.setForeground(new java.awt.Color(254, 254, 254));
        newButton.setFocusPainted(false);
        newButton.setFocusable(false);
        newButton.setText("Nouveau");
        newButton.setMaximumSize(new java.awt.Dimension(69, 30));
        newButton.setMinimumSize(new java.awt.Dimension(69, 30));
        newButton.setName("new"); // NOI18N
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        loadButton.setBackground(new java.awt.Color(65, 65, 65));
        loadButton.setForeground(new java.awt.Color(254, 254, 254));
        loadButton.setFocusPainted(false);
        loadButton.setFocusable(false);
        loadButton.setText("Charger");
        loadButton.setMaximumSize(new java.awt.Dimension(65, 30));
        loadButton.setMinimumSize(new java.awt.Dimension(65, 30));
        loadButton.setName("load"); // NOI18N
        loadButton.setOpaque(true);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(65, 65, 65));
        saveButton.setForeground(new java.awt.Color(254, 254, 254));
        saveButton.setFocusPainted(false);
        saveButton.setFocusable(false);
        saveButton.setText("Sauvegarder");
        saveButton.setName("save"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(65, 65, 65));
        removeButton.setForeground(new java.awt.Color(254, 254, 254));
        removeButton.setFocusPainted(false);
        removeButton.setFocusable(false);
        removeButton.setText("Supprimer");
        removeButton.setMaximumSize(new java.awt.Dimension(79, 30));
        removeButton.setMinimumSize(new java.awt.Dimension(79, 30));
        removeButton.setName("remove"); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        GroupLayout menuBarLayout = new GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addComponent(newButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton)
                    .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        undo.setIcon(new ImageIcon(getClass().getResource("icons/DataContainer_MovePreviousHS.png"))); // NOI18N
        undo.setFocusPainted(false);
        undo.setFocusable(false);
        undo.setName("undo"); // NOI18N
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setIcon(new ImageIcon(getClass().getResource("icons/DataContainer_MoveNextHS.png"))); // NOI18N
        redo.setFocusPainted(false);
        redo.setFocusable(false);
        redo.setName("undo"); // NOI18N
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        displayMode.setModel(new DefaultComboBoxModel(new String[] { "Tout afficher", "Sommets", "Arrêtes" }));
        displayMode.setFocusable(false);
        displayMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                displayModeItemStateChanged(evt);
            }
        });

        algorithms.setModel(new DefaultComboBoxModel(new String[] { "Aucun Algorithme", "Aleatoire", "Circulaire", "Modele de force", "Colorisation", "Calcul d'indice", "Taille", "Personnalisé" }));
        algorithms.setFocusable(false);
        algorithms.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algorithmsItemStateChanged(evt);
            }
        });

        zoomIn.setIcon(new ImageIcon(getClass().getResource("icons/zoomIn.png"))); // NOI18N
        zoomIn.setFocusable(false);
        zoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });

        zoomOut.setIcon(new ImageIcon(getClass().getResource("icons/zoomOut.png"))); // NOI18N
        zoomOut.setFocusable(false);
        zoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });

        copy.setIcon(new ImageIcon(getClass().getResource("icons/copy.png"))); // NOI18N
        copy.setFocusable(false);
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        cut.setIcon(new ImageIcon(getClass().getResource("icons/cut.png"))); // NOI18N
        cut.setFocusable(false);
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });

        paste.setIcon(new ImageIcon(getClass().getResource("icons/paste.png"))); // NOI18N
        paste.setFocusable(false);
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });

        add.setIcon(new ImageIcon(getClass().getResource("icons/add.png"))); // NOI18N
        add.setToolTipText("");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setIcon(new ImageIcon(getClass().getResource("icons/delete.png"))); // NOI18N
        delete.setFocusable(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        GroupLayout toolBarLayout = new GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addComponent(undo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algorithms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoomIn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoomOut)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copy)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cut)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paste)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addGap(0, 256, Short.MAX_VALUE))
            .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toolBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(toolBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(displayMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(algorithms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(zoomIn))
                    .addComponent(zoomOut)
                    .addComponent(copy)
                    .addComponent(cut)
                    .addComponent(redo)
                    .addComponent(undo)
                    .addComponent(paste)
                    .addComponent(add)
                    .addComponent(delete))
                .addContainerGap())
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    // Actions
	private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("new");
	}

	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("load");
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("save");
	}

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("remove");
	}

	private void undoActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("undo");
	}

	private void redoActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("redo");
	}

	private void displayModeItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			System.out.println(displayMode.getSelectedItem());
		}
	}

	private void algorithmsItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			System.out.println(algorithms.getSelectedItem());
		}
	}

	private void zoomInActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("zoomIn");
	}

	private void zoomOutActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("zoomOut");
	}

	private void copyActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("copy");
	}

	private void cutActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("cut");
	}

	private void pasteActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("paste");
	}

	private void addActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("add");
	}

	private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("delete");
	}
	
	
	// Drawing
    private void mainPanelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.out.println(evt.getX());
        System.out.println(evt.getY());
     }   

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
