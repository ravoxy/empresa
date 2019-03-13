$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget);

    var codigo = button.data('codigo');

    var modal = $(this);
    var form = modal.find('form');
    var action = form.attr('action');
    if (action.substring(action.length -1, action.length) !== ('/')) {
        action += '/';
    }
    form.attr('action', action + codigo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir o usuário?');
});