module.exports = {
    TCP_PORT: process.env.TCP_PORT || 12345,
    TCP_HOST: process.env.TCP_HOST || 'servidor',
    WS_PORT: process.env.WS_PORT || 8080,
    CLIENT_PREFIX: process.env.CLIENT_PREFIX || "ClienteWeb"
};
