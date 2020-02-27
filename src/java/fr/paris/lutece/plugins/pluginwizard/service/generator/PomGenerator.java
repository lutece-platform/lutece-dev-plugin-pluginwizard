/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.pluginwizard.service.generator;

import fr.paris.lutece.plugins.pluginwizard.business.ConfigurationKey;
import fr.paris.lutece.plugins.pluginwizard.business.ConfigurationKeyHome;
import fr.paris.lutece.plugins.pluginwizard.business.model.PluginModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Pom generator is responsible of generating a project object model used by maven
 *
 */
public class PomGenerator extends AbstractFileGenerator
{

    /**
     * {@inheritDoc }
     */
    @Override
    public Map generate( PluginModel pm )
    {
        HashMap map = new HashMap( );
        map.put( getFilePath( pm ), getCode( pm ) );

        return map;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String getCode( PluginModel pm )
    {
        Map<String, Object> model = new HashMap<>( );
        Collection<ConfigurationKey> listKeys = ConfigurationKeyHome.getConfigurationKeysList( );

        // Fetches the actual configuration values to be replaced in the templates
        for ( ConfigurationKey key : listKeys )
        {
            model.put( key.getKeyDescription( ).trim( ), key.getKeyValue( ) );
        }

        model.put( MARK_KOTLIN, isKotlin( ) );
        model.put( Markers.MARK_PLUGIN, pm );
        model.put( Markers.MARK_CORE_VERSION, getCoreVersion( ) );

        return build( model );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String getFilename( PluginModel pm )
    {
        return "pom.xml";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getPath( )
    {
        return "";
    }
}
