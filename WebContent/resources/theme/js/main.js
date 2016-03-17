var valuuta = new Object();
valuuta.cal = {
		
	defaultFrom: 	"EEK",
	defaultTo: 		"EUR",
	defaultKp:		"2010-12-30",
	
		
	init: function(){
		
		// kuupäeva datepicker
	    valuuta.cal.addDatePicker("[name='kp']");
	    
	    // kõik nupud jQuery buttoniteks, kujunduse pärast:)
	    jQuery(".nupp").button();
	    
	    // Clear e. Puhasta nupp
	    jQuery(".formContainer").on("click", "#clearButton", 
				function(e){valuuta.cal.clearButtonHandler(e)});
	    
	    // Valuuta valikute määramine
	    valuuta.cal.initSelect();
	    
	    // Vormi valideerimise loogika lisamine
	    valuuta.cal.initValuutaVormValideerimine();
	},
	
	
	/*
	 * kuupäeva datepicker
	 */
	addDatePicker: function(el){
	    jQuery(el).datepicker({
			  dateFormat: "yy-mm-dd",
			  showButtonPanel: true
		});
	},
	
	
	clearButtonHandler: function(e){
		
		e.preventDefault();
		jQuery("[name='summa']").val("");
		jQuery("[name='kp']").val(valuuta.cal.defaultKp);
		jQuery("#tulemused").text("");
		jQuery("#msg").text("");
	  
		selectValitudFrom(defaultFrom);;
		selectValitudTo(defaultTo);
	},
	
	
	/*
	 * Valuuta Select'idele uude või default valuuta väärtuste määramine
	 */
	initSelect: function(){
		var valitudFrom = 	valuuta.cal.defaultFrom;
	    var valitudTo = 	valuuta.cal.defaultTo;
	    if(jQuery("[name='fromP']").val() !== ""){
	    	valitudFrom = jQuery("[name='fromP']").val();
	    }
	    if(jQuery("[name='toP']").val() !== ""){
	    	valitudTo = jQuery("[name='toP']").val();
	    }
	    valuuta.cal.selectValitudFrom(valitudFrom);
	    valuuta.cal.selectValitudTo(valitudTo);
	},
	
	
	selectValitudFrom: function(valitudFrom){
		jQuery("[name='from'] #" + from).prop("selected", true);
	},
	
	
	selectValitudTo: function(valitudTo){
		jQuery("[name='to'] #" + to).prop("selected", true);
	},
	
	
	/*
	 * valuuta kalkulaatori vormi valideerimise loogika
	 */
	initValuutaVormValideerimine: function(){
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
	}
}


jQuery(document ).ready(function() {
	
	valuuta.cal.init();	 
});
