package com.gl4.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.gl4.tp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActionMode.Callback {

    private  lateinit var binding : ActivityMainBinding
    private  lateinit var actionMode: ActionMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment,FragmentClock(),null)
            .addToBackStack(null)
            .commit()

        binding.ButtonId.setOnLongClickListener{
            actionMode = this@MainActivity.startActionMode(this@MainActivity)!!
            return@setOnLongClickListener true
        }
    }

    fun setTime(view: View?) {

        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()
        var fragmentClock = FragmentClock()
        var bundle = Bundle()
        bundle.putBoolean("digitalOK",binding.SwitchId.isChecked)
        fragmentClock.arguments = bundle
        transaction.replace(R.id.fragment,fragmentClock)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_ressource_file, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_switch)
        {
            binding.SwitchId.isChecked = !binding.SwitchId.isChecked
            setTime(null)
        }
        return super.onOptionsItemSelected(item)
    }

    /* Menu Contextuel */
    /* L’implémentation de l'interface ActionMode.Callback */

    /* comportement à la création du mode contextuel */
    override fun onCreateActionMode(actionMode: ActionMode, menu: Menu?): Boolean {
        val inflater: MenuInflater = actionMode.menuInflater
        inflater.inflate(R.menu.context_mode_menu, menu)
        return true
    }

    override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
        return true
    }
    /* comportement au clic sur un élément de la barre contextuelle */
    override fun onActionItemClicked(actionMode: ActionMode?, menuItem: MenuItem?): Boolean {
        return when (menuItem?.itemId) {
            R.id.action_color -> {
                binding.ButtonId.setBackgroundColor(
                    resources.getColor(
                        R.color.teal_200
                    )
                )
                actionMode?.finish()
                true
            }
            else -> false
        }
    }
    /* comportement à la fermeture du mode contextuel */
    override fun onDestroyActionMode(p0: ActionMode?) {
    }
}