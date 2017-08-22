/*
 * lottery.fake.js
 * Fake module
*/

/*global $, lottery */

lottery.fake = (function () {
  'use strict';
  var getPeopleList, fakeIdSerial, makeFakeId, mockSio;

  fakeIdSerial = 32;

  makeFakeId = function () {
    return 'id_' + String( fakeIdSerial++ );
  };

  getPeopleList = function () {
      var dataroot="lottery.json"; 
	  $.getJSON(dataroot, function(data){ 
	 
	     alert(data)
       }); 


    
  };

  mockSio = (function () {
    var on_sio, emit_sio, callback_map = {};

    on_sio = function ( msg_type, callback ) {
      callback_map[ msg_type ] = callback;
    };

    emit_sio = function ( msg_type, data ) {

      // respond to 'adduser' event with 'userupdate'
      // callback after a 3s delay
      //
      if ( msg_type === 'adduser' && callback_map.userupdate ) {
        setTimeout( function () {
          callback_map.userupdate(
            [{  _id     : makeFakeId(),
                name    : data.name,
                img_src : data.css_map
            }]
          );
        }, 3000 );
      }
    };

    return { emit : emit_sio, on : on_sio };
  }());

  return {
    getPeopleList : getPeopleList,
    mockSio       : mockSio
  };
}());