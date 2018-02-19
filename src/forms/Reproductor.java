package forms;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Reproductor extends javax.swing.JFrame {

    private final EmbeddedMediaPlayerComponent player;
    private final ArrayList<File> list;
    private boolean band = true;
    private int playing = 0;

    /**
     * Creates new form Reproductor
     * @param vlc
     */
    public Reproductor(String vlc) {
        initComponents();

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlc);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        player = new EmbeddedMediaPlayerComponent();
        panelReprodutor.add(player);
        player.setSize(panelReprodutor.getSize());
        player.setVisible(true);

        list = new ArrayList<>();

        //Listener para acompanhar a reprodução no jSlideProgresso
        player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void positionChanged(MediaPlayer mp, float pos) {
                if (band) {
                    int value = Math.min(100, Math.round(pos * 100.0f));
                    slideProgresso.setValue(value);
                }
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {

            }

        });

    }

    private void play() {

        if (!list.isEmpty()) {
            String reprod = list.get(playing).getAbsolutePath();
            player.getMediaPlayer().playMedia(reprod);
            slideVolume.setValue(player.getMediaPlayer().getVolume());
            slideProgresso.setEnabled(true);
            setTitle("JMediaPlayer - " + list.get(playing).getName());
            menuSnap.setEnabled(true);
        }

    }

    private void enabledButtons(boolean op) {

        btnPlay.setEnabled(op);
        btnPause.setEnabled(op);
        btnStop.setEnabled(op);
        btnPrev.setEnabled(op);
        btnProx.setEnabled(op);

        menuPause.setEnabled(op);

    }

    private void playlistDialog() {

        PlayList dialog = new PlayList(this, true, list);
        dialog.setVisible(true);

        if (dialog.isConfirme()) {
            playing = dialog.getSelectIndex();
            play();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReprodutor = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnMute = new javax.swing.JToggleButton();
        slideVolume = new javax.swing.JSlider();
        jToolBar2 = new javax.swing.JToolBar();
        lbTime = new javax.swing.JLabel();
        slideProgresso = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuSnap = new javax.swing.JMenuItem();
        menuPause = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JMediaPlayer");
        setMinimumSize(new java.awt.Dimension(500, 400));

        panelReprodutor.setBackground(new java.awt.Color(204, 204, 204));
        panelReprodutor.setMinimumSize(new java.awt.Dimension(100, 100));
        panelReprodutor.setPreferredSize(new java.awt.Dimension(400, 300));
        panelReprodutor.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnPlay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        btnPlay.setToolTipText("Play");
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.setEnabled(false);
        btnPlay.setMaximumSize(new java.awt.Dimension(50, 33));
        btnPlay.setMinimumSize(new java.awt.Dimension(50, 33));
        btnPlay.setPreferredSize(new java.awt.Dimension(50, 33));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPlay);

        btnPause.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pasue.png"))); // NOI18N
        btnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPause.setEnabled(false);
        btnPause.setMaximumSize(new java.awt.Dimension(50, 33));
        btnPause.setMinimumSize(new java.awt.Dimension(50, 33));
        btnPause.setPreferredSize(new java.awt.Dimension(50, 33));
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPause);

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stop.png"))); // NOI18N
        btnStop.setToolTipText("Stop");
        btnStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStop.setEnabled(false);
        btnStop.setFocusable(false);
        btnStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStop.setMaximumSize(new java.awt.Dimension(50, 33));
        btnStop.setMinimumSize(new java.awt.Dimension(50, 33));
        btnStop.setPreferredSize(new java.awt.Dimension(50, 33));
        btnStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStop);

        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prev.png"))); // NOI18N
        btnPrev.setToolTipText("Anterior");
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrev.setEnabled(false);
        btnPrev.setFocusable(false);
        btnPrev.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrev.setMaximumSize(new java.awt.Dimension(50, 33));
        btnPrev.setMinimumSize(new java.awt.Dimension(50, 33));
        btnPrev.setPreferredSize(new java.awt.Dimension(50, 33));
        btnPrev.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrev);

        btnProx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnProx.setToolTipText("Proximo");
        btnProx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProx.setEnabled(false);
        btnProx.setFocusable(false);
        btnProx.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProx.setMaximumSize(new java.awt.Dimension(50, 33));
        btnProx.setMinimumSize(new java.awt.Dimension(50, 33));
        btnProx.setPreferredSize(new java.awt.Dimension(50, 33));
        btnProx.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProx);

        btnList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/align-justify.png"))); // NOI18N
        btnList.setToolTipText("Playlist");
        btnList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnList.setFocusable(false);
        btnList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnList.setMaximumSize(new java.awt.Dimension(50, 33));
        btnList.setMinimumSize(new java.awt.Dimension(50, 33));
        btnList.setPreferredSize(new java.awt.Dimension(50, 33));
        btnList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        jToolBar1.add(btnList);
        jToolBar1.add(jSeparator1);

        btnMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/muteOn.png"))); // NOI18N
        btnMute.setText("100%");
        btnMute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMute.setFocusable(false);
        btnMute.setMaximumSize(new java.awt.Dimension(100, 35));
        btnMute.setMinimumSize(new java.awt.Dimension(100, 35));
        btnMute.setPreferredSize(new java.awt.Dimension(100, 35));
        btnMute.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnMuteStateChanged(evt);
            }
        });
        btnMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMute);

        slideVolume.setPaintTicks(true);
        slideVolume.setValue(100);
        slideVolume.setMaximumSize(new java.awt.Dimension(150, 33));
        slideVolume.setMinimumSize(new java.awt.Dimension(150, 33));
        slideVolume.setPreferredSize(new java.awt.Dimension(150, 33));
        slideVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideVolumeStateChanged(evt);
            }
        });
        jToolBar1.add(slideVolume);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("00:00");
        lbTime.setMaximumSize(new java.awt.Dimension(50, 33));
        lbTime.setMinimumSize(new java.awt.Dimension(50, 33));
        lbTime.setPreferredSize(new java.awt.Dimension(50, 33));
        jToolBar2.add(lbTime);

        slideProgresso.setPaintTicks(true);
        slideProgresso.setValue(0);
        slideProgresso.setEnabled(false);
        slideProgresso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideProgressoStateChanged(evt);
            }
        });
        slideProgresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                slideProgressoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slideProgressoMouseReleased(evt);
            }
        });
        jToolBar2.add(slideProgresso);

        jMenu1.setText("Arquivo");

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setText("Abrir Arquivo");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuOpen);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Controle");

        menuSnap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuSnap.setText("Capturar");
        menuSnap.setEnabled(false);
        menuSnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSnapActionPerformed(evt);
            }
        });
        jMenu3.add(menuSnap);

        menuPause.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        menuPause.setText("Pausar / Continuar");
        menuPause.setEnabled(false);
        menuPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPauseActionPerformed(evt);
            }
        });
        jMenu3.add(menuPause);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Playlist");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Sobre");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReprodutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelReprodutor, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Arquivos de video...");
        String[] ext = {"mp4", "mpeg", "avi", "flv", "webm", "mkv", "rmvb"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Videos", ext);
        fileChooser.setFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            list.addAll(Arrays.asList(files));
            enabledButtons(true);
            setTitle("JMediaPlayer - " + list.get(playing).getName());
        }

    }//GEN-LAST:event_menuOpenActionPerformed

    private void menuSnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSnapActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione caminho do VLC...");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int op = fileChooser.showOpenDialog(null);

        if (op == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String newPath = file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".png";

            if (player.getMediaPlayer().saveSnapshot(new File(newPath))) {
                JOptionPane.showMessageDialog(null, "Capturado em " + newPath);
            }

        }


    }//GEN-LAST:event_menuSnapActionPerformed

    private void slideVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideVolumeStateChanged
        // TODO add your handling code here:

        player.getMediaPlayer().setVolume(slideVolume.getValue());
        btnMute.setText(slideVolume.getValue() + "%");

    }//GEN-LAST:event_slideVolumeStateChanged

    private void slideProgressoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideProgressoStateChanged
        // TODO add your handling code here:
        if (!band) {
            float np = slideProgresso.getValue() / 100f;
            player.getMediaPlayer().setPosition(np);
        }
    }//GEN-LAST:event_slideProgressoStateChanged

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying());
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here: 
        play();
        btnPlay.setFocusable(false);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        player.getMediaPlayer().stop();
        slideProgresso.setValue(0);
        slideProgresso.setEnabled(false);
    }//GEN-LAST:event_btnStopActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:

        if (playing > 0) {
            playing--;
        } else {
            playing = list.size() - 1;
        }

        play();

    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        // TODO add your handling code here:

        if (playing < list.size() - 1) {
            playing++;
        } else {
            playing = 0;
        }

        play();

    }//GEN-LAST:event_btnProxActionPerformed

    private void slideProgressoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideProgressoMousePressed
        // TODO add your handling code here:
        band = false;
    }//GEN-LAST:event_slideProgressoMousePressed

    private void slideProgressoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideProgressoMouseReleased
        // TODO add your handling code here:
        band = true;
    }//GEN-LAST:event_slideProgressoMouseReleased

    private void btnMuteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnMuteStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_btnMuteStateChanged

    private void btnMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuteActionPerformed
        // TODO add your handling code here:

        Icon ico;// = new ImageIcon(this.getClass().getResource("/img/muteOn"));

        if (btnMute.isSelected()) {
            ico = new ImageIcon(this.getClass().getResource("/img/muteOff.png"));
        } else {
            ico = new ImageIcon(this.getClass().getResource("/img/muteOn.png"));
        }

        player.getMediaPlayer().mute(btnMute.isSelected());
        btnMute.setIcon(ico);

    }//GEN-LAST:event_btnMuteActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        playlistDialog();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        playlistDialog();

    }//GEN-LAST:event_btnListActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        Sobre sb = new Sobre(this, true);
        sb.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void menuPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPauseActionPerformed
        // TODO add your handling code here:
        player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying());
    }//GEN-LAST:event_menuPauseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnList;
    private javax.swing.JToggleButton btnMute;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnProx;
    private javax.swing.JButton btnStop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbTime;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuPause;
    private javax.swing.JMenuItem menuSnap;
    private javax.swing.JPanel panelReprodutor;
    private javax.swing.JSlider slideProgresso;
    private javax.swing.JSlider slideVolume;
    // End of variables declaration//GEN-END:variables
}
