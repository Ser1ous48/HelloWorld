package com.pm.helloworld.fragments
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pm.helloworld.R
import com.pm.helloworld.data.entities.PrimeiraClasse
import com.pm.helloworld.data.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        setHasOptionsMenu(true)

        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        return view;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_futebol, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //hideKeyboard()

        if (item.itemId == R.id.menu_add) {
            addProduct()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun addProduct() {
        if (!isValid()) {
            return Toast.makeText(
                requireContext(),
                getString(R.string.empty_game),
                Toast.LENGTH_LONG
            ).show()
        }

        val product = PrimeiraClasse(0, productName.text.toString())

        mProductViewModel.addProduct(product)

        Toast.makeText(
            requireContext(),
            getString(R.string.added_game),
            Toast.LENGTH_LONG
        ).show()

        findNavController().navigate(R.id.action_add2_to_listFragment)
    }

    private fun isValid() : Boolean {
        return !TextUtils.isEmpty(productName.text.toString())
    }
}