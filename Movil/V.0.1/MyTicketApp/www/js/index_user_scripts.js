(function()
{
 "use strict";
 /*
   hook up event handlers 
 */
 function register_event_handlers()
 {
    
    
     /* button  .uib_w_4 */
    
    
        /* button  .uib_w_4 */
    $(document).on("click", ".uib_w_4", function(evt)
    {
         /* Other possible functions are: 
           uib_sb.open_sidebar($sb)
           uib_sb.close_sidebar($sb)
           uib_sb.toggle_sidebar($sb)
            uib_sb.close_all_sidebars()
          See js/sidebar.js for the full sidebar API */
        
         uib_sb.toggle_sidebar($(".uib_w_2"));  
    });
    
        /* button  Login */
    $(document).on("click", ".uib_w_18", function(evt)
    {
        alert('Voy');
    });
    
        /* button  Login */
    $(document).on("click", ".uib_w_18", function(evt)
    {
         /*global activate_subpage */
         activate_subpage("#login"); 
    });
    
        /* listitem  Eventos */
    $(document).on("click", ".uib_w_6", function(evt)
    {
         /*global activate_subpage */
         activate_subpage("#login"); 
    });
    
        /* listitem  Eventos */
    $(document).on("click", ".uib_w_9", function(evt)
    {
         /*global activate_subpage */
         activate_subpage("#login"); 
    });
    
    }
 document.addEventListener("app.Ready", register_event_handlers, false);
})();
