package client;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.IOException;

/**
 *
 * Duy Pham 30038701 MusicPlayer for Java Project
 *
 */
public class musicPlayer extends javax.swing.JFrame {

    private File directory;
    private File[] files;
    private LinkedList<File> songList = new LinkedList<File>();
    private String[] tempArray;
    private int songNumber;
    private Media media;
    private MediaPlayer mediaPlayer;
    private static int min = 0;
    private static int max;
    private static int mid;
    private CSVWriter writer = null;

    public musicPlayer() {
        initComponents();
    }

    public static int stringBinarySearch(LinkedList<File> searchList, String key) {
        while (min <= max) {
            mid = (min + max) / 2;
            if (searchList.get(mid).getName().compareTo(key) < 0) {
                min = mid + 1;
            } else if (searchList.get(mid).getName().compareTo(key) > 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //mergeSort
    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }// end mergeSort

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }//end merge

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        currentlyPlayingLabel = new javax.swing.JLabel();
        playingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songTB = new javax.swing.JTextArea();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        searchTB = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        outPutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Player");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        currentlyPlayingLabel.setText("Currently playing:");

        playingLabel.setText("null");

        songTB.setColumns(20);
        songTB.setRows(5);
        jScrollPane1.setViewportView(songTB);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        outPutButton.setText("Output");
        outPutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outPutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentlyPlayingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playingLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchTB)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(playButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(previousButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(outPutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentlyPlayingLabel)
                    .addComponent(playingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousButton)
                        .addGap(5, 5, 5)
                        .addComponent(outPutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        playingLabel.setText(songList.get(songNumber).getName());
        mediaPlayer.play();
    }//GEN-LAST:event_playButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new JFXPanel();
        directory = new File("music");
        files = directory.listFiles();
        tempArray = new String[files.length];
        int counter = 0;
        max = files.length;
        //save into tempArray
        if (files != null) {
            for (File file : files) {
                tempArray[counter] = file.toString();
                counter++;
            }
        }
        //sort array
        mergeSort(tempArray, 0, tempArray.length - 1);
        for (int i = 0; i < counter; i++) {
            File tempFile = new File(tempArray[i]);
            songList.add(tempFile);
            songTB.append(songList.get(i).getName() + "\r\n");
        }
        media = new Media(songList.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }//GEN-LAST:event_formWindowOpened

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (songNumber < songList.size() - 1) {
            songNumber++;
            mediaPlayer.stop();
            media = new Media(songList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playingLabel.setText(songList.get(songNumber).getName());
            mediaPlayer.play();
        } else {
            songNumber = 0;

            mediaPlayer.stop();

            media = new Media(songList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playingLabel.setText(songList.get(songNumber).getName());

            mediaPlayer.play();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (songNumber > 0) {
            songNumber--;
            mediaPlayer.stop();
            media = new Media(songList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playingLabel.setText(songList.get(songNumber).getName());
            mediaPlayer.play();
        } else {
            songNumber = songList.size() - 1;

            mediaPlayer.stop();

            media = new Media(songList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playingLabel.setText(songList.get(songNumber).getName());

            mediaPlayer.play();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchSong = searchTB.getText() + ".wav";
        int searched = stringBinarySearch(songList, searchSong);
        if (searched == -1) {
            JOptionPane.showMessageDialog(null, "Song not found!");
        } else {
            JOptionPane.showMessageDialog(null, "Song found at: " + (searched + 1) + "\r\nName: " + songList.get(searched).getName());
        }
        //reset binarySearch
        min = 0;
        max = files.length;
        searchTB.setText("");
    }//GEN-LAST:event_searchButtonActionPerformed

    private void outPutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outPutButtonActionPerformed
        try {
            writer = new CSVWriter(new FileWriter("SongList.txt"));
            for (int i = 0; i < files.length; i++) {
                String[] data = {songList.get(i).getName()};
                writer.writeNext(data);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_outPutButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        File htmlFile = new File("helpFiles.html"); // file object of the help file
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException ex) {
            System.out.println("IOException occrus: " + ex);
        }
    }//GEN-LAST:event_helpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(musicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentlyPlayingLabel;
    private javax.swing.JButton helpButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton outPutButton;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel playingLabel;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTB;
    private javax.swing.JTextArea songTB;
    // End of variables declaration//GEN-END:variables
}
