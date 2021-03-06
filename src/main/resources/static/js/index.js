
$('#excluirCasa').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var codigoCasa = button.data('codigo');
	
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoCasa);
});

$('#excluirShow').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var codigoShow = button.data('codigo');
	
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoShow);
});
$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',' , thousands: '.' , allowzero: true  });
});
$(function(){
    $(".data").mask("99/99/9999",{placeholder:" "});
    $(".rg").mask("99.999.999-9",{placeholder:" "});
    $(".cpf").mask("999.999.999-99",{placeholder:" "});
    $(".telefone").mask("(99) 99999-9999",{placeholder:" "});
	$(".cep").mask("99999-999",{placeholder:" "});
});

