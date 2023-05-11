<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : book.xsl
    Created on : May 9, 2023, 9:28 PM
    Author     : vy
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <body>
                <h1>List of books</h1>
                <table>
                    <tbody>
                        <tr>
                            <th>ISBN-10</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Publisher</th>
                            <th>Publication Date</th>
                            <th>Price</th>
                        </tr>
                        <xsl:for-each select="Books/Book"> 
                        <tr>
                            <td>
                                <xsl:value-of select="ISBN-10"/>
                            </td>
                            <td>
                                <xsl:value-of select="Title"/>
                            </td>
                            <td>
                                <xsl:value-of select="Author"/>
                            </td>
                            <td>
                                <xsl:value-of select="Publisher"/>
                            </td>
                            <td>
                                <xsl:value-of select="PublicationDate"/>
                            </td>
                            <td>
                                <xsl:value-of select="Price"/>
                            </td>
                        </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
