const net = require('net');
const { TCP_PORT, TCP_HOST } = require('../config');

function createTCPConnection(ws, alias) {
    const tcpClient = new net.Socket();

    tcpClient.connect(TCP_PORT, TCP_HOST, () => {
        console.log(`Conectado al servidor Java TCP en ${TCP_HOST}:${TCP_PORT}`);
    });

    // Reenvía datos del servidor Java al navegador
    tcpClient.on('data', (data) => {
        if (ws.readyState === ws.OPEN) {
            ws.send(data.toString());
        }
    });

    tcpClient.on('close', () => {
        console.log("Conexión TCP cerrada");
        if (ws.readyState === ws.OPEN) {
            ws.close();
        }
    });

    tcpClient.on('error', (err) => {
        console.error("Error TCP:", err.message);
        if (ws.readyState === ws.OPEN) {
            ws.send("Error al conectar con el servidor Java: " + err.message);
            ws.close();
        }
    });

    return tcpClient;
}

module.exports = { createTCPConnection };
