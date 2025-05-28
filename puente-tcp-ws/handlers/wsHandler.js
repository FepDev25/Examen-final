const WebSocket = require('ws');
const { WS_PORT, CLIENT_PREFIX } = require('../config');
const { createTCPConnection } = require('./tcpHandler');

function startWebSocketServer() {
    const wss = new WebSocket.Server({ port: WS_PORT });
    console.log(`Servidor WebSocket disponible en ws://localhost:${WS_PORT}`);

    wss.on('connection', (ws) => {
        console.log("Cliente WebSocket conectado");

        const tcpClient = createTCPConnection(ws, CLIENT_PREFIX);

        ws.on('message', (message) => {
            tcpClient.write(`${CLIENT_PREFIX}: ${message}\n`);
        });

        ws.on('close', () => {
            console.log("WebSocket desconectado");
            tcpClient.end();
        });
    });
}

module.exports = { startWebSocketServer };
