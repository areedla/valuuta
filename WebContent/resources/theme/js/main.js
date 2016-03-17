var defaultFrom = "EEK";
var defaultTo = "EUR";

jQuery(document ).ready(function() {
	
	// kõik nupud jQuery buttoniteks, kujunduse pärast:)
    jQuery( ".nupp" ).button();
    
    // kuupäeva datepicker
    jQuery("[name='kp']").datepicker({
		  dateFormat: "yy-mm-dd",
		  showButtonPanel: true
	});
    
    // puhastamisnupu loogika
    jQuery("#clearButton").click(function(e){
    	  e.preventDefault();
		  jQuery("[name='summa']").val("");
		  jQuery("[name='kp']").val("2010-12-30");
		  jQuery("#tulemused").text("");
		  jQuery("#msg").text("");
		  
		  selectValitudFrom(defaultFrom);;
		  selectValitudTo(defaultTo);
	});
    
    
    // valuuta valikute määramine vormil
    var valitudFrom = defaultFrom;
    var valitudTo = defaultTo;
    if(jQuery("[name='fromP']").val() !== ""){
    	valitudFrom = jQuery("[name='fromP']").val();
    }
    if(jQuery("[name='toP']").val() !== ""){
    	valitudTo = jQuery("[name='toP']").val();
    }
    selectValitudFrom(valitudFrom);
    selectValitudTo(valitudTo);
    
    
    // formi valideerimine
    jQuery("#valuutaForm").submit(function(e) {
        	e.preventDefault();
    }).validate({
        rules: {
            summa: {
                required: true,
                number: true
            },
            kp: {
                required: true,
                date: true,
                minlength: 6,
            },
            from: required=true,
            to: required=true,
        },
        submitHandler: function(form) {
        	form.submit();
        }
    });
	 
});

function selectValitudFrom(from){
	jQuery("[name='from'] #" + from).prop("selected", true);
}

function selectValitudTo(to){
	jQuery("[name='to'] #" + to).prop("selected", true);
}