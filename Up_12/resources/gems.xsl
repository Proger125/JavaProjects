<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
    <head>
        <style>
            .header_row{
                background-color: green;
            }
        </style>
    </head>
    <body>
        <h2>Natural gems</h2>
        <table border="1">
            <tr class="header_row">
                <th>Id</th>
                <th>Name</th>
                <th>Preciousness</th>
                <th>Color</th>
                <th>Transparency</th>
                <th>Edge amount</th>
                <th>Creation date</th>
                <th>Extraction place</th>
            </tr>
            <xsl:for-each select="gems/natural-gem">
                <tr>
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="preciousness"/></td>
                    <td><xsl:value-of select="visual-parameters/color"/></td>
                    <td><xsl:value-of select="visual-parameters/transparency"/></td>
                    <td><xsl:value-of select="visual-parameters/edge-amount"/></td>
                    <td><xsl:value-of select="creation-date"/></td>
                    <td><xsl:value-of select="extraction-place"/></td>
                </tr>
            </xsl:for-each>
        </table>
        <h2>Artificial gems</h2>
        <table border="1">
            <tr class="header_row">
                <th>Id</th>
                <th>Name</th>
                <th>Preciousness</th>
                <th>Color</th>
                <th>Transparency</th>
                <th>Edge amount</th>
                <th>Creation date</th>
                <th>Growing time</th>
            </tr>
            <xsl:for-each select="gems/artificial-gem">
                <tr>
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="preciousness"/></td>
                    <td><xsl:value-of select="visual-parameters/color"/></td>
                    <td><xsl:value-of select="visual-parameters/transparency"/></td>
                    <td><xsl:value-of select="visual-parameters/edge-amount"/></td>
                    <td><xsl:value-of select="creation-date"/></td>
                    <td><xsl:value-of select="growing-time"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </body>
</html>
</xsl:template>

</xsl:stylesheet>