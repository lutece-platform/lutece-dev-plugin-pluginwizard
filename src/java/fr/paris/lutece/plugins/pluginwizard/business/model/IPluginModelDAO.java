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
package fr.paris.lutece.plugins.pluginwizard.business.model;

import fr.paris.lutece.portal.service.plugin.Plugin;

import java.util.Collection;

/**
 * IPluginModelDAO Interface
 */
public interface IPluginModelDAO
{
    /**
     * Insert a new record in the table.
     * 
     * @param pluginModel
     *            instance of the PluginModel object to inssert
     * @param plugin
     *            the Plugin
     */
    void insert( PluginModel pluginModel, Plugin plugin );

    /**
     * Update the record in the table
     * 
     * @param pluginModel
     *            the reference of the PluginModel
     * @param plugin
     *            the Plugin
     */
    void store( PluginModel pluginModel, Plugin plugin );

    /**
     * Delete a record from the table
     * 
     * @param nIdPluginModel
     *            int identifier of the PluginModel to delete
     * @param plugin
     *            the Plugin
     */
    void delete( int nIdPluginModel, Plugin plugin );

    // /////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the data from the table
     * 
     * @param nKey
     *            The id of the plugin model
     * @param plugin
     *            the Plugin
     * @return The instance of the pluginModel
     */
    PluginModel load( int nKey, Plugin plugin );

    /**
     * Load the data of all the pluginModel objects and returns them as a collection
     * 
     * @param plugin
     *            the Plugin
     * @return The collection which contains the data of all the pluginModel objects
     */
    Collection<PluginModel> selectPluginModelsList( Plugin plugin );

    /**
     * The identifier of the generated plugin
     * 
     * @param plugin
     *            The plugin
     * @param strName
     *            The generated plugin name
     * @return The identifier of the plugin generated
     */
    int selectPluginModelByName( Plugin plugin, String strName );

    /**
     *
     * @param strPluginName
     *            The plugin name
     * @param plugin
     *            The plugin
     * @return a Boolean
     */
    boolean pluginExists( String strPluginName, Plugin plugin );
}
