use grafiles

db.usuarios.createIndex({ usuario: 1 }, { unique: true })

db.usuarios.insertMany([
{
    _id: ObjectId('67208c0fe7e7276130fe691a'),
    nombre: 'Juan Pérez',
    usuario: 'usuario5',
    password: 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
    email: 'juan.perez@example.com',
    tipo: 'usuario',
    carpetaRaiz: {
      _id: ObjectId('67208c0fe7e7276130fe6911'),
      nombre: 'Mi Nube',
      archivos: [
        {
          _id: ObjectId('67208c0fe7e7276130fe6912'),
          nombre: 'documento1.txt',
          tipo: 'txt',
          contenido: 'binData',
          'tamaño': 2048
        },
        {
          _id: ObjectId('6723d087f4e40a1eda8e8966'),
          nombre: 'archivoprueba',
          path: '/raiz//archivoprueba',
          tipo: 'html',
          contenido: ''
        },
        {
          _id: ObjectId('6723d1d50e4454181b160f10'),
          nombre: 'archivoPrubatxt',
          path: '/raiz//archivoPrubatxt',
          tipo: 'txt',
          contenido: ''
        }
      ],
      subcarpetas: [
        {
          _id: ObjectId('67208c0fe7e7276130fe6913'),
          nombre: 'Fotos de Vacaciones',
          archivos: [
            {
              _id: ObjectId('67208c0fe7e7276130fe6914'),
              nombre: 'playa.png',
              tipo: 'png',
              contenido: 'binData',
              'tamaño': 4096
            }
          ],
          subcarpetas: [
            {
              _id: ObjectId('67208c0fe7e7276130fe6915'),
              nombre: 'Playa',
              archivos: [
                {
                  _id: ObjectId('67208c0fe7e7276130fe6916'),
                  nombre: 'atardecer.jpg',
                  tipo: 'jpg',
                  contenido: 'binData',
                  'tamaño': 5120
                },
                {
                  _id: ObjectId('67208c0fe7e7276130fe6917'),
                  nombre: 'familia.jpg',
                  tipo: 'jpg',
                  contenido: 'binData',
                  'tamaño': 6144
                }
              ],
              subcarpetas: []
            }
          ]
        },
        {
          _id: ObjectId('67208c0fe7e7276130fe6918'),
          nombre: 'Documentos',
          archivos: [
            {
              _id: ObjectId('67208c0fe7e7276130fe6919'),
              nombre: 'resumen.html',
              tipo: 'html',
              contenido: 'binData',
              'tamaño': 1024
            }
          ],
          subcarpetas: []
        },
        {
          _id: ObjectId('67221037a32a777b0f6993bd'),
          nombre: 'Carpeta1',
          path: '/raizusuario5/Carpeta1',
          archivos: [],
          subcarpetas: []
        },
        {
          _id: ObjectId('6723d06ff4e40a1eda8e8964'),
          nombre: 'Prueba',
          path: '/raizusuario5/Prueba',
          archivos: [
            {
              _id: ObjectId('6723d20f0e4454181b160f11'),
              nombre: 'archivo',
              path: 'null/archivo',
              tipo: 'html',
              contenido: ' <html>\n</html>'
            }
          ],
          subcarpetas: []
        },
        {
          _id: ObjectId('6723d1b60e4454181b160f0f'),
          nombre: 'carpetaPruebaa',
          path: '/raizusuario5/carpetaPruebaa',
          archivos: [],
          subcarpetas: []
        }
      ]
    }
  },
  {
    _id: ObjectId('67217f2f309fe61da7fe691a'),
    nombre: 'Administrador 1',
    usuario: 'admin1',
    password: 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
    email: 'admin1@example.com',
    tipo: 'admin',
    carpetaRaiz: {
      _id: ObjectId('67217f2f309fe61da7fe6911'),
      nombre: 'Mi Nube',
      archivos: [
        {
          _id: ObjectId('67217f2f309fe61da7fe6912'),
          nombre: 'documento1.txt',
          tipo: 'txt',
          contenido: 'binData',
          'tamaño': 2048
        }
      ],
      subcarpetas: [
        {
          _id: ObjectId('67217f2f309fe61da7fe6913'),
          nombre: 'Fotos de Vacaciones',
          archivos: [
            {
              _id: ObjectId('67217f2f309fe61da7fe6914'),
              nombre: 'playa.png',
              tipo: 'png',
              contenido: 'binData',
              'tamaño': 4096
            }
          ],
          subcarpetas: [
            {
              _id: ObjectId('67217f2f309fe61da7fe6915'),
              nombre: 'Playa',
              archivos: [
                {
                  _id: ObjectId('67217f2f309fe61da7fe6916'),
                  nombre: 'atardecer.jpg',
                  tipo: 'jpg',
                  contenido: 'binData',
                  'tamaño': 5120
                },
                {
                  _id: ObjectId('67217f2f309fe61da7fe6917'),
                  nombre: 'familia.jpg',
                  tipo: 'jpg',
                  contenido: 'binData',
                  'tamaño': 6144
                }
              ],
              subcarpetas: []
            }
          ]
        },
        {
          _id: ObjectId('67217f2f309fe61da7fe6918'),
          nombre: 'Documentos',
          archivos: [
            {
              _id: ObjectId('67217f2f309fe61da7fe6919'),
              nombre: 'resumen.html',
              tipo: 'html',
              contenido: 'binData',
              'tamaño': 1024
            }
          ],
          subcarpetas: []
        }
      ]
    }
  },
  {
    _id: ObjectId('672219d668f7fa28fd6bb6e8'),
    nombre: 'usuario 6',
    usuario: 'usuario6',
    password: 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
    email: 'correo@correo.com',
    tipo: 'usuario',
    carpetaRaiz: {
      _id: ObjectId('672219d668f7fa28fd6bb6e7'),
      nombre: 'nubeusuario6',
      path: '/raizusuario6',
      archivos: [
        {
          _id: ObjectId('672355e6b602342b590006b2'),
          nombre: 'Archivo1',
          path: '/raiz//Archivo1',
          tipo: 'txt',
          contenido: 'Archivo1'
        },
        {
          _id: ObjectId('6723562e115ac14ab468e04e'),
          nombre: 'Archivo2',
          path: '/raiz//Archivo2',
          tipo: 'html',
          contenido: ' '
        },
        {
          _id: ObjectId('67235e2d115ac14ab468e069'),
          nombre: 'Archvio11',
          path: '/raiz//Archvio11',
          tipo: 'txt',
          contenido: ' '
        },
        {
          _id: ObjectId('67235ed5115ac14ab468e06b'),
          nombre: 'A',
          path: '/raiz//A',
          tipo: 'txt',
          contenido: ' '
        },
        {
          _id: ObjectId('67235f08115ac14ab468e06d'),
          nombre: 'A1',
          path: '/raiz//A1',
          tipo: 'txt',
          contenido: 'Contenido Nuevo\n'
        },
        {
          _id: ObjectId('6723ba69eaeae97cc31bbe59'),
          nombre: 'A2',
          path: '/raiz//A2',
          tipo: 'txt',
          contenido: 'Holaaaa'
        }
      ],
      subcarpetas: [
        {
          _id: ObjectId('672219e168f7fa28fd6bb6ea'),
          nombre: 'Carpeta1',
          path: '/raizusuario6/Carpeta1',
          archivos: [
            {
              _id: ObjectId('6723c144414a622d22cefd79'),
              nombre: 'Archivo1Carpeta',
              path: 'null/Archivo1Carpeta',
              tipo: 'txt',
              contenido: 'dassdaddsadsa'
            },
            {
              _id: ObjectId('6723c146414a622d22cefd7a'),
              nombre: 'Archivo1Carpeta',
              path: 'null/Archivo1Carpeta',
              tipo: 'txt',
              contenido: ' '
            },
            {
              _id: ObjectId('6723c21e414a622d22cefd7b'),
              nombre: 'Archivo33',
              path: 'null/Archivo33',
              tipo: 'txt',
              contenido: ' '
            },
            {
              _id: ObjectId('6723c268c996200df8847aad'),
              nombre: 'Archivo5',
              path: 'null/Archivo5',
              tipo: 'html',
              contenido: ' '
            },
            {
              _id: ObjectId('6723c2b1c996200df8847aae'),
              nombre: 'archivo5',
              path: 'null/archivo5',
              tipo: 'html',
              contenido: ' '
            },
            {
              _id: ObjectId('6723c2bec996200df8847aaf'),
              nombre: 'sddsa',
              path: 'null/sddsa',
              tipo: 'html',
              contenido: 'holaaaaa archivito'
            }
          ],
          subcarpetas: []
        },
        {
          _id: ObjectId('67221a1d68f7fa28fd6bb6eb'),
          nombre: 'Carpeta1',
          path: '/raizusuario6/Carpeta1',
          archivos: [],
          subcarpetas: []
        },
        {
          _id: ObjectId('6723bb3c4daef261e7418d99'),
          nombre: 'Carpeta111',
          path: '/raizusuario6/Carpeta111',
          archivos: [],
          subcarpetas: []
        },
        {
          _id: ObjectId('6723bb6f4daef261e7418d9a'),
          nombre: 'carpeta1',
          path: '/raizusuario6/carpeta1',
          archivos: [],
          subcarpetas: []
        },
        {
          _id: ObjectId('6723bcb74daef261e7418d9c'),
          nombre: 'Carp2',
          path: '/raizusuario6/Carp2',
          archivos: [
            {
              _id: ObjectId('6723c51799a5aa47dbfb1b65'),
              nombre: 'Archivo2',
              path: 'null/Archivo2',
              tipo: 'txt',
              contenido: 'Otro contenudo'
            }
          ],
          subcarpetas: []
        }
      ]
    }
  },
  {
    _id: ObjectId('672296f29ed29177694e3ac5'),
    nombre: 'Yenny salvaje ',
    usuario: 'yenny',
    password: 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
    email: 'correo@cooreo.com',
    tipo: 'usuario',
    carpetaRaiz: {
      _id: ObjectId('672296f29ed29177694e3ac4'),
      nombre: 'nubeyenny',
      path: '/raizyenny',
      archivos: [],
      subcarpetas: [
        {
          _id: ObjectId('672296fe9ed29177694e3ac8'),
          nombre: 'Yenny salvaje ',
          path: '/raizyenny/Yenny salvaje ',
          archivos: [],
          subcarpetas: []
        },
        {
          _id: ObjectId('672297229ed29177694e3ac9'),
          nombre: 'carpeta',
          path: '/raizyenny/carpeta',
          archivos: [],
          subcarpetas: []
        }
      ]
    }
  },
  {
    _id: ObjectId('6722a4029ed29177694e3acf'),
    nombre: 'Oli',
    usuario: 'holi',
    password: '597c1f492fb2cf682d89006b39f5c4e09bfc5e5946e60ff7f530b3cb2ec0f9a6',
    email: 'correo.deOl@asd.com',
    tipo: 'usuario',
    carpetaRaiz: {
      _id: ObjectId('6722a4029ed29177694e3ace'),
      nombre: 'nubeholi',
      path: '/raizholi',
      archivos: [],
      subcarpetas: [
        {
          _id: ObjectId('6722a4309ed29177694e3ad1'),
          nombre: 'nueva_carpeta',
          path: '/raizholi/nueva_carpeta',
          archivos: [],
          subcarpetas: []
        }
      ]
    }
  },
  {
    _id: ObjectId('6723d2550e4454181b160f14'),
    nombre: 'usuario 10',
    usuario: 'usuario10',
    password: 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
    email: 'correo@correo.com',
    tipo: 'usuario',
    carpetaRaiz: {
      _id: ObjectId('6723d2550e4454181b160f13'),
      nombre: 'nubeusuario10',
      path: '/raizusuario10',
      archivos: [
        {
          _id: ObjectId('6723d2760e4454181b160f17'),
          nombre: 'Archivo1',
          path: '/raiz//Archivo1',
          tipo: 'txt',
          contenido: ' txt'
        },
        {
          _id: ObjectId('6723d27f0e4454181b160f18'),
          nombre: 'Archivo2',
          path: '/raiz//Archivo2',
          tipo: 'html',
          contenido: ' html'
        }
      ],
      subcarpetas: [
        {
          _id: ObjectId('6723d2690e4454181b160f16'),
          nombre: 'Carpeta1',
          path: '/raizusuario10/Carpeta1',
          archivos: [
            {
              _id: ObjectId('6723d29d0e4454181b160f19'),
              nombre: 'Archivo1',
              path: 'null/Archivo1',
              tipo: 'html',
              contenido: ' html'
            },
            {
              _id: ObjectId('6723d2b10e4454181b160f1a'),
              nombre: 'Archivo2oiuiuoiu',
              path: 'null/Archivo2oiuiuoiu',
              tipo: 'html',
              contenido: ' jsldñlskadñlad'
            }
          ],
          subcarpetas: []
        }
      ]
    }
  }




])

