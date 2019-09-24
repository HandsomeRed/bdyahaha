CKEDITOR.plugins.add('uploadPicture', {
    requires: ['dialog'],
    init: function (a) {
        var b = a.addCommand('uploadPicture', new CKEDITOR.dialogCommand('uploadPicture'));
        a.ui.addButton('uploadPicture', {
            label: a.lang.date.toolbar,
            command: 'uploadPicture',
            icon: this.path + 'images/uploadPicture.jpg'
        });
        CKEDITOR.dialog.add('uploadPicture', this.path + 'dialogs/date.js');
    }
});