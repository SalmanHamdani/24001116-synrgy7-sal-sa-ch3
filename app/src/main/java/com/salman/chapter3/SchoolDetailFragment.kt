import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.salman.chapter3.School
import com.salman.chapter3.databinding.FragmentSchoolDetailBinding

class SchoolDetailFragment : Fragment() {

    private lateinit var binding: FragmentSchoolDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedSchool = arguments?.getParcelable<School>("selectedSchool")

        selectedSchool?.let {
            binding.schoolImage.load(it.image)
            binding.schoolName.text = it.name
            binding.btnSearch.setOnClickListener { view ->
                searchOnGoogle()
            }
        }
    }

    private fun searchOnGoogle() {
        val selectedSchool = arguments?.getParcelable<School>("selectedSchool")
        selectedSchool?.let {
            val searchQuery = "${it.name}"
            val searchUrl = "https://www.google.com/search?q=${Uri.encode(searchQuery)}"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(searchUrl)
            startActivity(intent)
        }
    }
}


