/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.analysis.ui.options;

import java.awt.Cursor;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.php.analysis.commands.PHPStan;
import org.netbeans.modules.php.analysis.options.AnalysisOptions;
import org.netbeans.modules.php.analysis.options.AnalysisOptionsValidator;
import org.netbeans.modules.php.api.util.FileUtils;
import org.netbeans.modules.php.api.util.UiUtils;
import org.netbeans.modules.php.api.validation.ValidationResult;
import org.openide.awt.HtmlBrowser;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.ChangeSupport;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

public class PHPStanOptionsPanel extends AnalysisCategoryPanel {

    private static final String PHPSTAN_LAST_FOLDER_SUFFIX = ".phpstan"; // NOI18N
    private static final String PHPSTAN_CONFIGURATION_LAST_FOLDER_SUFFIX = ".phpstan.config"; // NOI18N
    private static final long serialVersionUID = -968090640401936313L;

    private final ChangeSupport changeSupport = new ChangeSupport(this);

    /**
     * Creates new form PHPStanOptionsPanel
     */
    public PHPStanOptionsPanel() {
        super();
        initComponents();
        init();
    }

    @NbBundle.Messages({
        "# {0} - short script name",
        "# {1} - long script name",
        "PHPStanOptionsPanel.hint=Full path of PHPStan script (typically {0} or {1}).",})
    private void init() {
        phpStanHintLabel.setText(Bundle.PHPStanOptionsPanel_hint(PHPStan.NAME, PHPStan.LONG_NAME));
        // add listener
        DefaultDocumentListener defaultDocumentListener = new DefaultDocumentListener();
        phpStanTextField.getDocument().addDocumentListener(defaultDocumentListener);
        phpStanConfigurationTextField.getDocument().addDocumentListener(defaultDocumentListener);
        phpStanLevelComboBox.addActionListener(e -> fireChange());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phpStanLabel = new javax.swing.JLabel();
        phpStanTextField = new javax.swing.JTextField();
        phpStanBrowseButton = new javax.swing.JButton();
        phpStanSearchButton = new javax.swing.JButton();
        phpStanHintLabel = new javax.swing.JLabel();
        phpStanLevelLabel = new javax.swing.JLabel();
        phpStanLevelComboBox = new javax.swing.JComboBox<>();
        phpStanConfigurationLabel = new javax.swing.JLabel();
        phpStanConfigurationTextField = new javax.swing.JTextField();
        phpStanConfiturationBrowseButton = new javax.swing.JButton();
        phpStanNoteLabel = new javax.swing.JLabel();
        phpStanMinVersionInfoLabel = new javax.swing.JLabel();
        phpStanLearnMoreLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(phpStanLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanLabel.text")); // NOI18N

        phpStanTextField.setText(org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(phpStanBrowseButton, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanBrowseButton.text")); // NOI18N
        phpStanBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phpStanBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(phpStanSearchButton, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanSearchButton.text")); // NOI18N
        phpStanSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phpStanSearchButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(phpStanHintLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanHintLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(phpStanLevelLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanLevelLabel.text")); // NOI18N

        phpStanLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));

        org.openide.awt.Mnemonics.setLocalizedText(phpStanConfigurationLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanConfigurationLabel.text")); // NOI18N

        phpStanConfigurationTextField.setText(org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanConfigurationTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(phpStanConfiturationBrowseButton, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanConfiturationBrowseButton.text")); // NOI18N
        phpStanConfiturationBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phpStanConfiturationBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(phpStanNoteLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanNoteLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(phpStanMinVersionInfoLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanMinVersionInfoLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(phpStanLearnMoreLabel, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.phpStanLearnMoreLabel.text")); // NOI18N
        phpStanLearnMoreLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phpStanLearnMoreLabelMousePressed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phpStanLearnMoreLabelMouseEntered(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PHPStanOptionsPanel.class, "PHPStanOptionsPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(phpStanNoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phpStanMinVersionInfoLabel)
                    .addComponent(phpStanLearnMoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phpStanConfigurationLabel)
                    .addComponent(phpStanLabel)
                    .addComponent(phpStanLevelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phpStanTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(phpStanHintLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phpStanBrowseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phpStanSearchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phpStanConfigurationTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phpStanConfiturationBrowseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(phpStanLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phpStanLabel)
                    .addComponent(phpStanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phpStanBrowseButton)
                    .addComponent(phpStanSearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phpStanHintLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phpStanConfigurationLabel)
                    .addComponent(phpStanConfigurationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phpStanConfiturationBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phpStanLevelLabel)
                    .addComponent(phpStanLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(phpStanNoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phpStanMinVersionInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phpStanLearnMoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("PHPStanOptionsPanel.browse.title=Select PHPStan")
    private void phpStanBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phpStanBrowseButtonActionPerformed
        File file = new FileChooserBuilder(PHPStanOptionsPanel.class.getName() + PHPSTAN_LAST_FOLDER_SUFFIX)
                .setFilesOnly(true)
                .setTitle(Bundle.PHPStanOptionsPanel_browse_title())
                .showOpenDialog();
        if (file != null) {
            phpStanTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_phpStanBrowseButtonActionPerformed

    @NbBundle.Messages({
        "PHPStanOptionsPanel.search.title=PHPStan scripts",
        "PHPStanOptionsPanel.search.scripts=PHPStan scripts:",
        "PHPStanOptionsPanel.search.pleaseWaitPart=PHPStan scripts",
        "PHPStanOptionsPanel.search.notFound=No PHPStan scripts found."
    })
    private void phpStanSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phpStanSearchButtonActionPerformed
        String phpStan = UiUtils.SearchWindow.search(new UiUtils.SearchWindow.SearchWindowSupport() {

            @Override
            public List<String> detect() {
                return FileUtils.findFileOnUsersPath(PHPStan.NAME, PHPStan.LONG_NAME);
            }

            @Override
            public String getWindowTitle() {
                return Bundle.PHPStanOptionsPanel_search_title();
            }

            @Override
            public String getListTitle() {
                return Bundle.PHPStanOptionsPanel_search_scripts();
            }

            @Override
            public String getPleaseWaitPart() {
                return Bundle.PHPStanOptionsPanel_search_pleaseWaitPart();
            }

            @Override
            public String getNoItemsFound() {
                return Bundle.PHPStanOptionsPanel_search_notFound();
            }
        });
        if (phpStan != null) {
            phpStanTextField.setText(phpStan);
        }
    }//GEN-LAST:event_phpStanSearchButtonActionPerformed

    private void phpStanLearnMoreLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phpStanLearnMoreLabelMouseEntered
        evt.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_phpStanLearnMoreLabelMouseEntered

    private void phpStanLearnMoreLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phpStanLearnMoreLabelMousePressed
        try {
            URL url = new URL("https://github.com/phpstan/phpstan"); // NOI18N
            HtmlBrowser.URLDisplayer.getDefault().showURL(url);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_phpStanLearnMoreLabelMousePressed

    @NbBundle.Messages("PHPStanOptionsPanel.configuration.browse.title=Select PHPStan Configuration File")
    private void phpStanConfiturationBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phpStanConfiturationBrowseButtonActionPerformed
        File file = new FileChooserBuilder(PHPStanOptionsPanel.class.getName() + PHPSTAN_CONFIGURATION_LAST_FOLDER_SUFFIX)
                .setFilesOnly(true)
                .setTitle(Bundle.PHPStanOptionsPanel_configuration_browse_title())
                .showOpenDialog();
        if (file != null) {
            phpStanConfigurationTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_phpStanConfiturationBrowseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton phpStanBrowseButton;
    private javax.swing.JLabel phpStanConfigurationLabel;
    private javax.swing.JTextField phpStanConfigurationTextField;
    private javax.swing.JButton phpStanConfiturationBrowseButton;
    private javax.swing.JLabel phpStanHintLabel;
    private javax.swing.JLabel phpStanLabel;
    private javax.swing.JLabel phpStanLearnMoreLabel;
    private javax.swing.JComboBox<String> phpStanLevelComboBox;
    private javax.swing.JLabel phpStanLevelLabel;
    private javax.swing.JLabel phpStanMinVersionInfoLabel;
    private javax.swing.JLabel phpStanNoteLabel;
    private javax.swing.JButton phpStanSearchButton;
    private javax.swing.JTextField phpStanTextField;
    // End of variables declaration//GEN-END:variables

    @NbBundle.Messages("PHPStanOptionsPanel.category.name=PHPStan")
    @Override
    public String getCategoryName() {
        return Bundle.PHPStanOptionsPanel_category_name();
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    @Override
    public void update() {
        AnalysisOptions options = AnalysisOptions.getInstance();
        setPHPStanPath(options.getPHPStanPath());
        setPHPStanConfigurationPath(options.getPHPStanConfigurationPath());
        setPHPStanLevel(options.getPHPStanLevel());
    }

    @Override
    public void applyChanges() {
        AnalysisOptions options = AnalysisOptions.getInstance();
        options.setPHPStanPath(getPHPStanPath());
        options.setPHPStanConfigurationPath(getPHPStanConfigurationPath());
        options.setPHPStanLevel(getPHPStanLevel());
    }

    @Override
    public boolean isChanged() {
        String saved = AnalysisOptions.getInstance().getPHPStanPath();
        String current = getPHPStanPath();
        if (saved == null ? !current.isEmpty() : !saved.equals(current)) {
            return true;
        }
        saved = AnalysisOptions.getInstance().getPHPStanConfigurationPath();
        current = getPHPStanConfigurationPath();
        if (saved == null ? !current.isEmpty() : !saved.equals(current)) {
            return true;
        }
        int savedInt = AnalysisOptions.getInstance().getPHPStanLevel();
        int currentInt = getPHPStanLevel();
        return savedInt != currentInt;
    }

    @Override
    public ValidationResult getValidationResult() {
        return new AnalysisOptionsValidator()
                .validatePHPStan(getPHPStanPath(), getPHPStanConfigurationPath())
                .getResult();
    }

    void fireChange() {
        changeSupport.fireChange();
    }

    public String getPHPStanPath() {
        return phpStanTextField.getText().trim();
    }

    private void setPHPStanPath(String path) {
        phpStanTextField.setText(path);
    }

    public String getPHPStanConfigurationPath() {
        return phpStanConfigurationTextField.getText().trim();
    }

    private void setPHPStanConfigurationPath(String path) {
        phpStanConfigurationTextField.setText(path);
    }

    public int getPHPStanLevel() {
        return Integer.parseInt((String) phpStanLevelComboBox.getSelectedItem());
    }

    private void setPHPStanLevel(int level) {
        phpStanLevelComboBox.setSelectedItem(String.valueOf(level));
    }

    //~ Inner classes
    private final class DefaultDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            processUpdate();
        }

        private void processUpdate() {
            fireChange();
        }

    }
}
