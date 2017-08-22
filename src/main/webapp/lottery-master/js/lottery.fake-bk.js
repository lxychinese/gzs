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
    return [
      { name : '程帆帆', _id : 'id_001',
        img_src:'avatar/id_001.jpg'
      },
      { name : '袁惟仁', _id : 'id_002',
         img_src:'avatar/id_002.jpg'
      },
      { name : '李大仁', _id : 'id_003',
         img_src:'avatar/id_003.jpg'
      },
      { name : '宋楚楚', _id : 'id_004',
         img_src:'avatar/id_004.jpg'
      },
      { name : '张零五', _id : 'id_005',
        img_src:'avatar/id_005.jpg'
      },
      { name : '袁零六', _id : 'id_006',
         img_src:'avatar/id_006.jpg'
      },
      { name : '李零七', _id : 'id_007',
         img_src:'avatar/id_007.jpg'
      },
      { name : '宋零八', _id : 'id_008',
         img_src:'avatar/id_008.jpg'
      },
      { name : '张零九', _id : 'id_009',
        img_src:'avatar/id_009.jpg'
      },
      { name : '袁一零', _id : 'id_010',
         img_src:'avatar/id_010.jpg'
      },
      { name : '李一一', _id : 'id_011',
         img_src:'avatar/id_011.jpg'
      },
      { name : '宋一二', _id : 'id_012',
         img_src:'avatar/id_012.jpg'
      },
      { name : '李一三', _id : 'id_013',
        img_src:'avatar/id_013.jpg'
      },
      { name : '王一四', _id : 'id_014',
         img_src:'avatar/id_014.jpg'
      },
      { name : '李一五', _id : 'id_015',
         img_src:'avatar/id_015.jpg'
      },
      { name : '宋一六', _id : 'id_016',
         img_src:'avatar/id_016.jpg'
      },
      { name : '曹一七', _id : 'id_017',
        img_src:'avatar/id_017.jpg'
      },
      { name : '钱一八', _id : 'id_018',
         img_src:'avatar/id_018.jpg'
      },
      { name : '周一九', _id : 'id_019',
         img_src:'avatar/id_019.jpg'
      },
      { name : '宋二零', _id : 'id_020',
         img_src:'avatar/id_020.jpg'
      },
      { name : '程二一', _id : 'id_021',
        img_src:'avatar/id_021.jpg'
      },
      { name : '袁二二', _id : 'id_022',
         img_src:'avatar/id_022.jpg'
      },
      { name : '李二三', _id : 'id_023',
         img_src:'avatar/id_023.jpg'
      },
      { name : '宋二四', _id : 'id_024',
         img_src:'avatar/id_024.jpg'
      },
      { name : '赵二五', _id : 'id_025',
        img_src:'avatar/id_025.jpg'
      },
      { name : '孙二六', _id : 'id_026',
         img_src:'avatar/id_026.jpg'
      },
      { name : '任二七', _id : 'id_027',
         img_src:'avatar/id_027.jpg'
      },
      { name : '崔二八', _id : 'id_028',
         img_src:'avatar/id_028.jpg'
      },
      { name : '胡二九', _id : 'id_029',
        img_src:'avatar/id_029.jpg'
      },
      { name : '孙三零', _id : 'id_030',
         img_src:'avatar/id_030.jpg'
      },
      { name : '李三一', _id : 'id_031',
         img_src:'avatar/id_031.jpg'
      },
      { name : '温三二', _id : 'id_032',
         img_src:'avatar/id_032.jpg'
      },
      { name : '黄三三', _id : 'id_033',
        img_src:'avatar/id_001.jpg'
      },
      { name : '夏三四', _id : 'id_034',
         img_src:'avatar/id_002.jpg'
      },
      { name : '邓三五', _id : 'id_035',
         img_src:'avatar/id_003.jpg'
      },
      { name : '付三六', _id : 'id_036',
         img_src:'avatar/id_004.jpg'
      },
      { name : '冯三七', _id : 'id_037',
        img_src:'avatar/id_005.jpg'
      },
      { name : '江三八', _id : 'id_038',
         img_src:'avatar/id_006.jpg'
      },
      { name : '高三九', _id : 'id_039',
         img_src:'avatar/id_007.jpg'
      },
      { name : '姜四零', _id : 'id_040',
         img_src:'avatar/id_008.jpg'
      },
      { name : '金四一', _id : 'id_041',
        img_src:'avatar/id_009.jpg'
      },
      { name : '江四二', _id : 'id_042',
         img_src:'avatar/id_010.jpg'
      },
      { name : '刘四三', _id : 'id_043',
         img_src:'avatar/id_011.jpg'
      },
      { name : '楚思思', _id : 'id_044',
         img_src:'avatar/id_012.jpg'
      },
      { name : '刘四五', _id : 'id_045',
        img_src:'avatar/id_013.jpg'
      },
      { name : '柳四六', _id : 'id_046',
         img_src:'avatar/id_014.jpg'
      },
      { name : '杨四七', _id : 'id_047',
         img_src:'avatar/id_015.jpg'
      },
      { name : '贾四八', _id : 'id_048',
         img_src:'avatar/id_016.jpg'
      },
      { name : '甄四九', _id : 'id_049',
        img_src:'avatar/id_017.jpg'
      },
      { name : '罗五零', _id : 'id_050',
         img_src:'avatar/id_018.jpg'
      },
      { name : '庞五一', _id : 'id_051',
         img_src:'avatar/id_019.jpg'
      },
      { name : '宋五二', _id : 'id_052',
         img_src:'avatar/id_020.jpg'
      },
      { name : '苏五三', _id : 'id_053',
        img_src:'avatar/id_021.jpg'
      },
      { name : '田五四', _id : 'id_054',
         img_src:'avatar/id_022.jpg'
      },
      { name : '李五五', _id : 'id_055',
         img_src:'avatar/id_023.jpg'
      },
      { name : '吴五六', _id : 'id_056',
         img_src:'avatar/id_024.jpg'
      },
      { name : '夏五七', _id : 'id_057',
        img_src:'avatar/id_025.jpg'
      },
      { name : '徐五八', _id : 'id_058',
         img_src:'avatar/id_026.jpg'
      },
      { name : '李五九', _id : 'id_059',
         img_src:'avatar/id_027.jpg'
      },
      { name : '庞六零', _id : 'id_060',
         img_src:'avatar/id_028.jpg'
      },
      { name : '严六一', _id : 'id_061',
        img_src:'avatar/id_029.jpg'
      },
      { name : '闫六二', _id : 'id_062',
         img_src:'avatar/id_030.jpg'
      },
      { name : '郑六三', _id : 'id_063',
         img_src:'avatar/id_031.jpg'
      },
      { name : '宋六四', _id : 'id_064',
         img_src:'avatar/id_032.jpg'
      },
      { name : '朱六五', _id : 'id_065',
        img_src:'avatar/id_001.jpg'
      },
      { name : '程六六', _id : 'id_066',
         img_src:'avatar/id_002.jpg'
      },
      { name : '郭六七', _id : 'id_067',
         img_src:'avatar/id_003.jpg'
      },
      { name : '陈六八', _id : 'id_068',
         img_src:'avatar/id_004.jpg'
      },
      { name : '黄六九', _id : 'id_069',
        img_src:'avatar/id_005.jpg'
      },
      { name : '盛七零', _id : 'id_070',
         img_src:'avatar/id_006.jpg'
      },
      { name : '支七一', _id : 'id_071',
         img_src:'avatar/id_007.jpg'
      },
      { name : '谢七二', _id : 'id_072',
         img_src:'avatar/id_008.jpg'
      },
      { name : '梁七三', _id : 'id_073',
        img_src:'avatar/id_009.jpg'
      },
      { name : '吕七四', _id : 'id_074',
         img_src:'avatar/id_010.jpg'
      },
      { name : '孟七五', _id : 'id_075',
         img_src:'avatar/id_011.jpg'
      },
      { name : '马七六', _id : 'id_076',
         img_src:'avatar/id_012.jpg'
      },
      { name : '杨七七', _id : 'id_077',
        img_src:'avatar/id_013.jpg'
      },
      { name : '霍七八', _id : 'id_078',
         img_src:'avatar/id_014.jpg'
      },
      { name : '秦七九', _id : 'id_079',
         img_src:'avatar/id_015.jpg'
      },
      { name : '有八零', _id : 'id_080',
         img_src:'avatar/id_016.jpg'
      },
      { name : '潘八一', _id : 'id_081',
        img_src:'avatar/id_017.jpg'
      },
      { name : '葛八二', _id : 'id_082',
         img_src:'avatar/id_018.jpg'
      },
      { name : '韩八三', _id : 'id_083',
         img_src:'avatar/id_019.jpg'
      },
      { name : '候八四', _id : 'id_084',
         img_src:'avatar/id_020.jpg'
      },
      { name : '吕八五', _id : 'id_085',
        img_src:'avatar/id_021.jpg'
      },
      { name : '汤八六', _id : 'id_086',
         img_src:'avatar/id_022.jpg'
      },
      { name : '安八七', _id : 'id_087',
         img_src:'avatar/id_023.jpg'
      },
      { name : '唐八八', _id : 'id_088',
         img_src:'avatar/id_024.jpg'
      },
      { name : '杜八九', _id : 'id_089',
        img_src:'avatar/id_025.jpg'
      },
      { name : '冉九零', _id : 'id_090',
         img_src:'avatar/id_026.jpg'
      },
      { name : '丛九一', _id : 'id_091',
         img_src:'avatar/id_027.jpg'
      },
      { name : '杜九二', _id : 'id_092',
         img_src:'avatar/id_028.jpg'
      },
      { name : '徐九三', _id : 'id_093',
        img_src:'avatar/id_029.jpg'
      },
      { name : '高九四', _id : 'id_094',
         img_src:'avatar/id_030.jpg'
      },
      { name : '周九五', _id : 'id_095',
         img_src:'avatar/id_031.jpg'
      },
      { name : '刘九六', _id : 'id_096',
         img_src:'avatar/id_032.jpg'
      },
      { name : '许九七', _id : 'id_097',
        img_src:'avatar/id_001.jpg'
      },
      { name : '藏九八', _id : 'id_098',
         img_src:'avatar/id_002.jpg'
      },
      { name : '李九九', _id : 'id_099',
         img_src:'avatar/id_003.jpg'
      },
      { name : '宋一百', _id : 'id_100',
         img_src:'avatar/id_004.jpg'
      },
      { name : '任百一', _id : 'id_101',
        img_src:'avatar/id_005.jpg'
      },
      { name : '王百二', _id : 'id_102',
         img_src:'avatar/id_006.jpg'
      },
      { name : '孔百三', _id : 'id_103',
         img_src:'avatar/id_007.jpg'
      },
      { name : '魏百四', _id : 'id_104',
         img_src:'avatar/id_008.jpg'
      },
      { name : '赵百五', _id : 'id_105',
        img_src:'avatar/id_009.jpg'
      },
      { name : '边百六', _id : 'id_106',
         img_src:'avatar/id_010.jpg'
      },
      { name : '方百七', _id : 'id_107',
         img_src:'avatar/id_011.jpg'
      },
      { name : '战百八', _id : 'id_108',
         img_src:'avatar/id_012.jpg'
      },
      { name : '童百九', _id : 'id_109',
        img_src:'avatar/id_013.jpg'
      },
      { name : '佟百十', _id : 'id_110',
         img_src:'avatar/id_014.jpg'
      },
      { name : '百时一', _id : 'id_111',
         img_src:'avatar/id_015.jpg'
      },
      { name : '宋112', _id : 'id_112',
         img_src:'avatar/id_016.jpg'
      },
      { name : '王113', _id : 'id_113',
        img_src:'avatar/id_017.jpg'
      },
      { name : '汤114', _id : 'id_114',
         img_src:'avatar/id_018.jpg'
      },
      { name : '李115', _id : 'id_115',
         img_src:'avatar/id_019.jpg'
      },
      { name : '刘116', _id : 'id_116',
         img_src:'avatar/id_020.jpg'
      },
      { name : '边117', _id : 'id_117',
        img_src:'avatar/id_021.jpg'
      },
      { name : '于118', _id : 'id_118',
         img_src:'avatar/id_022.jpg'
      },
      { name : '李119', _id : 'id_119',
         img_src:'avatar/id_023.jpg'
      },
      { name : '宋120', _id : 'id_120',
         img_src:'avatar/id_024.jpg'
      },
      { name : '韩121', _id : 'id_121',
        img_src:'avatar/id_025.jpg'
      },
      { name : '高122', _id : 'id_122',
         img_src:'avatar/id_026.jpg'
      },
      { name : '李123', _id : 'id_123',
         img_src:'avatar/id_027.jpg'
      },
      { name : '宋124', _id : 'id_124',
         img_src:'avatar/id_028.jpg'
      },
      { name : '姚125', _id : 'id_125',
        img_src:'avatar/id_029.jpg'
      },
      { name : '赵126', _id : 'id_126',
         img_src:'avatar/id_030.jpg'
      },
      { name : '寇127', _id : 'id_127',
         img_src:'avatar/id_031.jpg'
      },
      { name : '范128', _id : 'id_128',
         img_src:'avatar/id_032.jpg'
      },
      { name : '温129', _id : 'id_129',
         img_src:'avatar/id_027.jpg'
      },
      { name : '宋130', _id : 'id_130',
         img_src:'avatar/id_028.jpg'
      },
      { name : '申131', _id : 'id_131',
        img_src:'avatar/id_029.jpg'
      },
      { name : '柯132', _id : 'id_132',
         img_src:'avatar/id_030.jpg'
      },
      { name : '李133', _id : 'id_133',
         img_src:'avatar/id_031.jpg'
      },
      { name : '何134', _id : 'id_134',
         img_src:'avatar/id_032.jpg'
      },
      { name : '冯135', _id : 'id_135',
         img_src:'avatar/id_001.jpg'
      },
      { name : '杨136', _id : 'id_136',
         img_src:'avatar/id_002.jpg'
      },
      { name : '楚137', _id : 'id_137',
         img_src:'avatar/id_003.jpg'
      },
      { name : '寇138', _id : 'id_138',
         img_src:'avatar/id_004.jpg'
      },
      { name : '姚139', _id : 'id_139',
         img_src:'avatar/id_005.jpg'
      },
      { name : '包140', _id : 'id_140',
         img_src:'avatar/id_006.jpg'
      },
      { name : '毛141', _id : 'id_141',
         img_src:'avatar/id_007.jpg'
      },
      { name : '林142', _id : 'id_142',
         img_src:'avatar/id_008.jpg'
      }

    ];
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