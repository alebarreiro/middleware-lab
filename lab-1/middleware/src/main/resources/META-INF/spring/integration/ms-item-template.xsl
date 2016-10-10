<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template  match="/" >
        <xsl:variable name="fechaCreacion" select="/item/fecha-creacion/text()"/>
        <xsl:variable name="date" select="substring-before($fechaCreacion, 'T')" />
        <xsl:variable name="time" select="substring(substring-after($fechaCreacion, 'T'), 1, 8)" />
        <xsl:variable name="year" select="substring($date, 1, 4)" />
        <xsl:variable name="month" select="substring($date, 6, 2)" />
        <xsl:variable name="day" select="substring($date, 9, 2)" />
        <xsl:variable name="formatDateTime" select="concat($day, '/', $month, '/', $year, ' ', $time)"/>

        <xsl:variable name="idCliente" select="/item/id-cliente/text()"/>
        <xsl:variable name="idProducto" select="/item/id-producto/text()"/>
        <xsl:variable name="idOrden" select="/item/id-orden/text()"/>
        <xsl:variable name="idItem" select="string(/item/@id)"/>
        <xsl:variable name="idOrdenItem" select="concat($idOrden, $idItem)"/>

        <item>
            <id-cliente>
                <xsl:value-of select="$idCliente" />
            </id-cliente>
            <id-producto>
                <xsl:value-of select="$idProducto" />
            </id-producto>
            <fecha-hora-creacion>
                <xsl:value-of select="$formatDateTime" />
            </fecha-hora-creacion>
            <id-orden-item>
                <xsl:value-of select="$idOrdenItem" />
            </id-orden-item>
        </item>
    </xsl:template>
</xsl:stylesheet>