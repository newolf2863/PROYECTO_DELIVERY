package mod_transporte;

public enum Provincia {
    AZUAY(-2.90055, -79.00453),
    BOLIVAR(-1.5883, -79.0305),
    CAÑAR(-2.5583, -78.9382),
    CARCHI(0.8539, -77.8328),
    COTOPAXI(-0.9291, -78.6153),
    CHIMBORAZO(-1.67098, -78.64712),
    EL_ORO(-3.2586, -79.9554),
    ESMERALDAS(0.9522, -79.6536),
    GUAYAS(-2.20584, -79.90795),
    IMBABURA(0.3517, -78.1223),
    LOJA(-4.00789, -79.2113),
    LOS_RIOS(-1.1337, -79.464),
    MANABI(-0.8371, -80.1836),
    MORONA_SANTIAGO(-2.4674, -78.117),
    NAPO(-0.998, -77.8132),
    ORELLANA(-0.4695, -76.987),
    PASTAZA(-1.4558, -78.2802),
    PICHINCHA(-0.1464, -78.4751),
    SANTA_ELENA(-2.2325, -80.859),
    SANTO_DOMINGO_DE_LOS_TSACHILAS(-0.2504, -79.1787),
    SUCUMBIOS(0.0393, -76.8688),
    TUNGURAHUA(-1.2543, -78.6229),
    ZAMORA_CHINCHIPE(-4.0677, -78.9569);

    private double latitud;
    private double longitud;

    Provincia(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
