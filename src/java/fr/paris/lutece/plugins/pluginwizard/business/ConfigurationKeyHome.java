/*
 * Copyright (c) 2002-2022, City of Paris
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
package fr.paris.lutece.plugins.pluginwizard.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.Collection;

/**
 * This class provides instances management methods (create, find, ...) for ConfigurationKey objects
 */
public final class ConfigurationKeyHome
{
    // Static variable pointed at the DAO instance
    private static IConfigurationKeyDAO _dao = (IConfigurationKeyDAO) SpringContextService.getPluginBean( "pluginwizard", "pluginwizard.configurationKeyDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "pluginwizard" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private ConfigurationKeyHome( )
    {
    }

    /**
     * Create an instance of the configurationKey class
     * 
     * @param configurationKey
     *            The instance of the ConfigurationKey which contains the informations to store
     * @return The instance of configurationKey which has been created with its primary key.
     */
    public static ConfigurationKey create( ConfigurationKey configurationKey )
    {
        _dao.insert( configurationKey, _plugin );

        return configurationKey;
    }

    /**
     * Update of the configurationKey which is specified in parameter
     * 
     * @param configurationKey
     *            The instance of the ConfigurationKey which contains the data to store
     * @return The instance of the configurationKey which has been updated
     */
    public static ConfigurationKey update( ConfigurationKey configurationKey )
    {
        _dao.store( configurationKey, _plugin );

        return configurationKey;
    }

    /**
     * Remove the configurationKey whose identifier is specified in parameter
     * 
     * @param nConfigurationKeyId
     *            The configurationKey Id
     */
    public static void remove( int nConfigurationKeyId )
    {
        _dao.delete( nConfigurationKeyId, _plugin );
    }

    // /////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a configurationKey whose identifier is specified in parameter
     * 
     * @param nKey
     *            The configurationKey primary key
     * @return an instance of ConfigurationKey
     */
    public static ConfigurationKey findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }

    /**
     * Load the data of all the configurationKey objects and returns them in form of a collection
     * 
     * @return the collection which contains the data of all the configurationKey objects
     */
    public static Collection<ConfigurationKey> getConfigurationKeysList( )
    {
        return _dao.selectConfigurationKeysList( _plugin );
    }
}
