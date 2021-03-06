'use strict';
var LIVERELOAD_PORT = 35729;
var SERVER_PORT = 9000;
var lrSnippet = require('connect-livereload')({port: LIVERELOAD_PORT});
var mountFolder = function (connect, dir) {
    return connect.static(require('path').resolve(dir));
};

// # Globbing
// for performance reasons we're only matching one level down:
// 'test/spec/{,*/}*.js'
// use this if you want to match all subfolders:
// 'test/spec/**/*.js'
// templateFramework: 'lodash'

module.exports = function (grunt) {
    require('time-grunt')(grunt);
    require('load-grunt-tasks')(grunt);

    var yeomanConfig = {
        app: 'app',
        dist: 'dist'
    };

    grunt.initConfig({
        yeoman: yeomanConfig,
        express: {
            dev: {
                options: {
                    stdio: 'inherit',
                    background: false,
                    script: '.tmp/scripts/server.js'
                }
            }
        },
        watch: {
            options: {
                nospawn: true,
                livereload: true
            },
            coffee: {
                files: ['scripts/{,*/}*.coffee'],
                tasks: ['coffee:dist']
            },
            test: {
                files: ['.tmp/scripts'],
                tasks: ['test:true']
            },
            express: {
                files: []
            }
        },
        connect: {
            options: {
                port: SERVER_PORT,
                hostname: 'localhost'
            },
            test: {
                options: {
                    port: 9001,
                    middleware: function (connect) {
                        return [
                            lrSnippet,
                            mountFolder(connect, '.tmp/'),
                            mountFolder(connect, 'bower_components')
                        ];
                    }
                }
            },
        },
        open: {
            test: {
                path: 'http://localhost:<%= connect.test.options.port %>'
            }
        },
        clean: {
          test: ['.tmp']
        },
        mocha: {
            all: {
                options: {
                    run: true,
                    growlOnSuccess: true,
                    urls: ['http://localhost:<%= connect.test.options.port %>/index.html']
                }
            }
        },
        coffee: {
            dist: {
                files: [{
                    expand: true,
                    cwd: 'scripts',
                    src: '{,*/}*.coffee',
                    dest: '.tmp/scripts',
                    ext: '.js'
                }]
            },
        },
        copy: {
          test: {
            files: [{
              expand: true,
              cwd: 'specs',
              src: ['*'],
              dest: '.tmp/',
              filter: 'isFile'},
            ]
          }
        }
    })

    grunt.registerTask('serve', function (isConnected) {
        var testTasks = [
                'coffee',
                'copy',
                'express:dev',
            ];
        return grunt.task.run(testTasks);
    });

    grunt.registerTask('test', function (isConnected) {
        isConnected = Boolean(isConnected);
        var testTasks = [
                'clean:test',
                'coffee',
                'copy:test',
                'connect:test',
                'mocha',
	            'open:test',
                'watch'
            ];

        if(!isConnected) {
            return grunt.task.run(testTasks);
        } else {
            // already connected so not going to connect again, remove the connect:test task
            testTasks.splice(testTasks.indexOf('connect:test'), 1);
            return grunt.task.run(testTasks);
        }
    });
};
