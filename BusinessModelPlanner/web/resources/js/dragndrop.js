/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $(".draggable").draggable({
        revert: true,
        helper: 'clone',
        start: function (event, ui) {
            $(this).fadeTo('fast', 0.5);
        },
        stop: function (event, ui) {
            $(this).fadeTo(0, 1);
        }
    });
    $(".draggablee").draggable({
        revert: true,
        helper: 'clone',
        start: function (event, ui) {
            $(this).fadeTo('fast', 0.5);
        },
        stop: function (event, ui) {
            $(this).fadeTo(0, 1);
        }
    });

    $("#droppable").droppable({
        hoverClass: 'active',
        drop: function (event, ui) {
            this.value = $(ui.draggable).text();
        }
    });
    $("#droppablee").droppable({
        hoverClass: 'active',
        drop: function (event, ui) {
            this.value = $(ui.draggable).text();
        }
    });
});